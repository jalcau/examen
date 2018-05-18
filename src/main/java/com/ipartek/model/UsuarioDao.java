package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.ipartek.pojo.Usuario;

public class UsuarioDao {
	private static UsuarioDao INSTANCE = null;
	private UsuarioDao() {
	}
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDao();
		}
	}
	
	public static UsuarioDao getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	public Usuario check(String nombre, String pass) {
		Usuario resul = null;
		
		String sql = "SELECT u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.password as 'usuario_password'"
				+ "FROM usuario as u" + " u.nombre=? and u.password = ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, nombre);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					resul = mapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}



	public Usuario mapper(ResultSet rs) throws SQLException {
	Usuario u = new Usuario();
	u.setId(rs.getInt("usuario_id"));
	u.setNombre(rs.getString("usuario_nombre"));
	u.setPass(rs.getString("usuario_password"));
	return u;
}
}