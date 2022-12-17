package com.educacionit.implementaciones.MariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.interfases.DAO;
import com.educacionit.interfases.MariaDB;
import com.educacionit.utilidades.Fechas;

public class UsuarioImpl implements DAO<String, Usuario>, MariaDB {
	
	private PreparedStatement psInsertar;
	private PreparedStatement psModificar;
	private PreparedStatement psEliminar;
	private PreparedStatement psBuscarPorId;
	private PreparedStatement psListarUsuarios;
	
	private final String insertQuery = "insert into usuarios (correo, clave, fechaCreacion, fechaModificacion) values (?, AES_ENCRYPT(?,?),?,?)";
	private final String buscarUsuarioIdQuery = "select AES_DECRYPT(clave,?) as clave, fechaCreacion, fechaModificacion from usuarios where correo=?";
	
	public UsuarioImpl() {
		super();
		try {
			psInsertar = getConection().prepareStatement(insertQuery);
			psBuscarPorId = getConection().prepareStatement(buscarUsuarioIdQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertar(Usuario usuario) {
		try {
			psInsertar.setString(1, usuario.getCorreo());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, getKEY());
			psInsertar.setString(4, Fechas.getStringFromLocalDate(usuario.getFechaCreacion()));
			psInsertar.setString(5, Fechas.getStringFromLocalDateTime(usuario.getFechaModificacion()));
			
			return (psInsertar.executeUpdate() == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public boolean modificar(Usuario e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscarPorId(String correo) {
		Usuario usuario = new Usuario();
		try {
			psBuscarPorId.setString(1, getKEY());
			psBuscarPorId.setString(2, correo);
			
			ResultSet rs = psBuscarPorId.executeQuery();
			
			if (rs.next()) {
				
				usuario.setCorreo(correo);
				usuario.setClave(rs.getString("clave"));
				usuario.setFechaCreacion(Fechas.getLocalDateFromString(rs.getString("fechaCreacion")));
				usuario.setFechaModificacion(Fechas.getLocalDateTimeFromString(rs.getString("fechaModificacion")));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
