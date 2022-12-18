package com.educacionit.interfases;

import java.util.List;

import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;

public interface IUsuario {
	
	List<Usuario> listar();
	
	UsuarioDTO guardar(Usuario usuario);
	
	UsuarioDTO eliminar(Usuario usuario);
	
	UsuarioDTO buscarPorId(String correo);
	
	UsuarioDTO fromUsuario(Usuario usuario, String mensaje);
	
	Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO);
	
	
	List<UsuarioDTO> agregarTodos(List<Usuario> usuarios);

}
