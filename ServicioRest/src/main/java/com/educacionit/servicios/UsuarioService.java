package com.educacionit.servicios;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.educacionit.DTOs.ErrorDTO;
import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.MariaDB.UsuarioImpl;
import com.educacionit.interfases.IUsuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService implements IUsuario {
	private UsuarioImpl usuarioImplementacion = new UsuarioImpl();
	
	@GET
	@Path("/listar")
	public List<UsuarioDTO> listar() {
		List<UsuarioDTO> usuariosDTO = usuarioImplementacion.listar().stream()
				.map(usuario -> fromUsuario(usuario, null)).collect(Collectors.toList());
		return usuariosDTO;
	}

	
	@PUT
	@Path("/guardarJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(UsuarioDTO usuarioDto) {
		return Response.status(Status.CREATED)
				.entity(usuarioImplementacion.insertar(fromUsuarioDTO(usuarioDto)))
				.build();
	}
	
	@POST
	@Path("/guardarForm")
	public Response guardarFrom(@FormParam("correo") String correo, @FormParam("clave") String clave) {
		Usuario usuario = new Usuario();
		usuario.setClave(clave);
		usuario.setCorreo(correo);
		
		return Response.status(Status.CREATED)
				.entity(usuarioImplementacion.insertar(usuario))
				.build();
	}

	@DELETE
	@Path("/eliminarJSON")
	public Response eliminar(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioImplementacion.buscarPorId(usuarioDTO.getCorreo());
		if (usuario != null) {
			usuarioImplementacion.eliminar(usuario);
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/buscar/{correo}")
	public Response buscarPorId(@PathParam("correo") String correo) {
		Object respuestaDTO = buscar(correo);
		
		if (respuestaDTO == null || respuestaDTO.getClass().equals(ErrorDTO.class)) {
			ErrorDTO rta = (ErrorDTO)respuestaDTO;
			return Response.status(Status.NO_CONTENT)
					.entity(rta)
					.build();
		}
		
		
		
		return Response.status(Status.CREATED)
				.entity(respuestaDTO)
				.build();
	}
	
	@GET
	@Path("/buscarQ")
	public UsuarioDTO buscarPorQuery(@QueryParam("correo") String correo) {
		
		UsuarioDTO usuarioDTO = (UsuarioDTO) buscar(correo);
		return usuarioDTO;
	}
	
	public Object buscar(String correo) {
		Usuario usuariobuscado = usuarioImplementacion.buscarPorId(correo);
		if (null == usuariobuscado) {
			
			ErrorDTO errorDto = new ErrorDTO(1001, "No encontre el usuario");
			return errorDto;
		}
			
		return fromUsuario(usuariobuscado, "Usuario Encontrado correctamente");
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
	
	@GET
	@Path("/headerLogin")
	public Response headerLogin(@HeaderParam(value = "usuario-id") String usuario, @HeaderParam(value = "credential") String credential) {
		URI agoogle = null;
		try {
			agoogle = new URI("http://google.com");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if (usuario != null && credential != null) {
			if (usuario.equals("usuariocorrecto") && credential.equals("credentialOK")) {
				return Response.seeOther(agoogle).build();		
				//devuelvo un nuevo token JWT para que el usuario pueda hacerme request con su token de sesion.
			} else {
				ErrorDTO errorDto = new ErrorDTO(1002, "creenciales incorrectas");
				return Response.status(Status.CREATED)
						.entity(errorDto)
						.build();
			}
		} else {
			ErrorDTO errorDto = new ErrorDTO(1003, "No mandaste las credenciales");
			return Response.status(Status.CREATED)
					.entity(errorDto)
					.build();
		}
		
	}
	
	
	@GET
	@Path("/headerHTTP")
	public Response getHeaders() {
		for (Entry<String, List<String>> entry : headers.getRequestHeaders().entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		return Response.ok().build();
	}
	

	
	
	
	
	@Context
	HttpHeaders headers;
	

}
