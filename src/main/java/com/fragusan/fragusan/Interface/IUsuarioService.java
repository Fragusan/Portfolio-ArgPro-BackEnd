/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fragusan.fragusan.Interface;

import com.fragusan.fragusan.Entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    //traer todos
    public List<Usuario> getUsuario();
    //generar uno nuevo
    public void saveUsuario(Usuario user);
    //eliminar un usuario por id
    public void delUsuario(Long id);
    //buscar uno por id (no eliminarlo) y devuelve datos
    public Usuario findUsuaario(Long id);
}
