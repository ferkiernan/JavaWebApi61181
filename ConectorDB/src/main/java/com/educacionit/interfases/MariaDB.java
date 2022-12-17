package com.educacionit.interfases;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface MariaDB {
	//InputStream inputStremConfig = ClassLoader.getSystemResourceAsStream("database.properties");
	InputStream inputStremConfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
	Properties properties = new Properties();
	
	
	default Connection getConection() {
		Connection conexion = null;
		
		
		try {
			properties.load(inputStremConfig);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String clave = properties.getProperty("clave");
			String usuario = properties.getProperty("usuario");
			
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, clave);
			
			return conexion;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return conexion;
	}
	
	default String getKEY() {
		String key = null;
		try {
			properties.load(inputStremConfig);
			key = properties.getProperty("key");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return key;
	}

}
