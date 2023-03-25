package com.fragusan.fragusan.Security.Controller;

import com.fragusan.fragusan.Security.Dto.JwtDto;
import com.fragusan.fragusan.Security.Dto.LoginUsuario;
import com.fragusan.fragusan.Security.Dto.NuevoUsuario;
import com.fragusan.fragusan.Security.Entity.UsuarioDb;
import com.fragusan.fragusan.Security.Entity.Rol;
import com.fragusan.fragusan.Security.Enums.RolNombre;
import com.fragusan.fragusan.Security.Service.RolService;
import com.fragusan.fragusan.Security.Service.UsuarioService;
import com.fragusan.fragusan.Security.jwt.JwtProvider;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://localhost:4200")
public class AuthController {
   @Autowired
   PasswordEncoder passwordEncoder;
   @Autowired
   AuthenticationManager authenticationManager;  
   @Autowired
   UsuarioService usuarioService;
   @Autowired
   RolService rolService;
   @Autowired
   JwtProvider jwtProvider;
   //=================================
   
   @PostMapping("/new")
   public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
      if(bindingResult.hasErrors())
          return new ResponseEntity(new Mensaje("Verifique los campos ingresados"),HttpStatus.BAD_REQUEST);
      
      if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
          return new ResponseEntity(new Mensaje("Este userName ya se encuentra en uso"),HttpStatus.BAD_REQUEST);
      
      if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
          return new ResponseEntity(new Mensaje("Ese email ya se encuentra en uso"),HttpStatus.BAD_REQUEST);
      
      UsuarioDb usuario = new UsuarioDb(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
      nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
      
      Set<Rol> roles = new HashSet<>();
      roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
      
      if(nuevoUsuario.getRoles().contains("admin"))
          roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
      usuario.setRoles(roles);
      usuarioService.save(usuario);
      return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
   }
   @PostMapping("/login")
   public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
   if(bindingResult.hasErrors())
       return new ResponseEntity(new Mensaje("Campos ingresados de manera incorrcta"),HttpStatus.BAD_REQUEST);
   
   Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
   loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
   
   SecurityContextHolder.getContext().setAuthentication(authentication);
   
   String jwt = jwtProvider.generateToken(authentication);
   
   UserDetails userDetails = (UserDetails) authentication.getPrincipal();
   
   JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
   
   return new ResponseEntity(jwtDto, HttpStatus.OK);
   }
}
