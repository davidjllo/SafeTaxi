package com.dso.safetaxi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.safetaxi.dao.DbConnection;
import com.dso.safetaxi.entities.Usuarios;
import com.dso.safetaxi.exception.POSseWSException;

public class UsuariosService {

	public Usuarios getUsuario(String username) {
		Usuarios usuario = null;
		
		String query = "select * from users where username = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, username);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                usuario = new Usuarios(rs.getString("username"),rs.getString("password"));
//				usuario = new Usuarios(rs.getString("username"), 
//						               rs.getString("id_grupo"), 
//						               rs.getString("id_tercero"), 
//						               rs.getString("password"), 
//						               rs.getString("estado")
//						              );
			}
			
			ps.close();
			conexion.close();
			
			if (usuario == null) {
				throw new POSseWSException("Usuario no Existe");
			}
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return usuario;
	}
	
	public ArrayList<Usuarios> getUsuarios() {
		ArrayList<Usuarios> lstUsuarios = new ArrayList<Usuarios>();
		
		String query = "select * from users";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                              lstUsuarios.add(new Usuarios(rs.getString("username"),rs.getString("password")));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstUsuarios;
	}
	
	public int addUsuario(Usuarios newUsuario) {
		int Ok = -1;
		
		String query = "insert into users (username, id_grupo, id_tercero, password, estado) values (?, ?, ?, ?, ?)";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, newUsuario.getUsername());
			ps.setString(4, newUsuario.getPassword());
		
			Ok = ps.executeUpdate();
			try {
				conexion.commit();
			} catch (SQLException sqlEx) {
				conexion.rollback();
				throw new POSseWSException(sqlEx.getMessage());
			}
			
			ps.close();
			conexion.close();	
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return Ok;
	}
}
