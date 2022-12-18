package com.educacionit.servicios;

import java.util.Arrays;
import java.util.List;

import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.MariaDB.UsuarioImpl;
import com.educacionit.interfases.IUsuario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService implements IUsuario {
	private UsuarioImpl usuarioImplementacion = new UsuarioImpl();
	
	@GET
	@Path("/listar")
	public List<Usuario> listar() {
		return usuarioImplementacion.listar();
	}

	public UsuarioDTO guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDTO eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDTO buscarPorId(String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDTO fromUsuario(Usuario usuario, String mensaje) {
		UsuarioDTO usuarioDTO = null;
		if(usuario != null) {
			usuarioDTO = new UsuarioDTO();
			usuarioDTO.setCorreo(usuario.getCorreo());
			usuarioDTO.setClave(usuario.getClave());
			usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
			usuarioDTO.setFechaModificacion(usuario.getFechaModificacion());
			usuarioDTO.setMensaje(mensaje);
			return usuarioDTO;
		}
		
		return usuarioDTO;
	}

	public Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = null;
		if (usuarioDTO != null) {
			usuario = new Usuario();
			usuario.setCorreo(usuarioDTO.getCorreo());
			usuario.setClave(usuarioDTO.getClave());
			usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
			usuario.setFechaModificacion(usuarioDTO.getFechaModificacion());
			return usuario;
		}
		return usuario;
	}
	
	
	@GET
	@Path("/listarNombres")
	public List<String> listaString() {
		return Arrays.asList("uno","dos","tres");
	}
	
		public List<UsuarioDTO> agregarTodos(List<Usuario> usuarios) {
		// TODO Auto-generated method stub
		return null;
	}

}
