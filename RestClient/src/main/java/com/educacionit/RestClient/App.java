package com.educacionit.RestClient;

import java.net.URI;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.educacionit.dtos.UsuarioDTO;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       final URI url = UriBuilder.fromUri("http://localhost:8080/ServicioRest/apis").build();
       
       ClientConfig clientConfig = new ClientConfig();
       clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
       
       Client cliente = ClientBuilder.newClient(clientConfig);
       
       WebTarget targetUsuarios = cliente.target(url).path("usuarios");
       
       UsuarioDTO usuarioDTO = null;
       
       try {
    	   usuarioDTO = buscar("user5@educacionit.com", targetUsuarios);
    	   System.out.println(usuarioDTO.getCorreo() + " --- " + usuarioDTO.getMensaje());
       } catch (java.lang.RuntimeException e) {	
    	   e.printStackTrace();
       }
    	        
    }
    
    
    public static UsuarioDTO buscar(String correo, WebTarget target) {
    	Response response = target.path("buscar").path(correo).request(MediaType.APPLICATION_JSON).get();
    	System.out.println("Codigo rta: " + response.getStatus());
    	if (response.getStatus() == 204) {
    		throw new RuntimeException("No se encontro el usuario");
    	}
    	
    	return response.readEntity(UsuarioDTO.class);   	
    }
}
