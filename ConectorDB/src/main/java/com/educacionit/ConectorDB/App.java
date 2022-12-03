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
       Usuario user1 = new Usuario("user1@educacionit.com", "1234", Fechas.getLocalDateFromString("1981-01-11"), LocalDateTime.now());
       
       UsuarioImpl usuarioImpl = new UsuarioImpl();
       
       usuarioImpl.insertar(user1);
    }
}
