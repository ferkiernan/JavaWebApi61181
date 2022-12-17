package com.educacionit.ConectorDB;

import java.time.LocalDateTime;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.MariaDB.UsuarioImpl;
import com.educacionit.utilidades.Fechas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Usuario user2 = new Usuario("user2@educacionit.com", "passwordloca", Fechas.getLocalDateFromString("1981-02-22"), LocalDateTime.now());
       
       UsuarioImpl usuarioImpl = new UsuarioImpl();
       
       usuarioImpl.insertar(user2);
       
       Usuario usuarioRecuperado = usuarioImpl.buscarPorId("user1@educacionit.com");
       
       System.out.println(usuarioRecuperado);
       
       
       
    }
}
