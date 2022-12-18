package com.educacionit.servicios;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path(value= "/MiPrimerApp")
public class MiPrimerServicio {
	
	
	@GET
	@Path("/inicio")
	@Produces(MediaType.TEXT_HTML)
	public String inicio() {
		return "<h1> Hola Mundo </h1>";
	}
	
	
	//Patron Builder
	@GET
	@Path("/respuesta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response respuesta() {
		return Response.status(Status.CREATED).entity("{\"respuesta\" : \"Objeto Creado exitosamente\"}").build();
	}
}
