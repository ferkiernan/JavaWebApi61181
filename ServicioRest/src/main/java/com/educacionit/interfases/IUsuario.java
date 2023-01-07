package com.educacionit.interfases;

import java.util.List;

import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;

import jakarta.ws.rs.core.Response;

public interface IUsuario {
	
	List<UsuarioDTO> listar();
	
	Response guardar(UsuarioDTO usuarioDto);
	
	Response eliminar(UsuarioDTO usuarioDto);
	
	Response buscarPorId(String correo);
	
	UsuarioDTO fromUsuario(Usuario usuario, String mensaje);
	
	Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO);
	
	
	List<UsuarioDTO> agregarTodos(List<Usuario> usuarios);

}
