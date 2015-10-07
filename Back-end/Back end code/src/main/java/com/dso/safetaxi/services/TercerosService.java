package com.dso.safetaxi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.safetaxi.dao.DbConnection;
import com.dso.safetaxi.entities.Terceros;
import com.dso.safetaxi.exception.POSseWSException;

public class TercerosService {

	public Terceros getTercero(String idTercero) throws POSseWSException {
		Terceros tercero = null;
		
		String query = "select * from terceros where id_tercero = ?";
		PreparedStatement ps = null;
		 
		try {
			Connection conexion = DbConnection.getConnection();
			ps = conexion.prepareStatement(query);
			ps.setString(1, idTercero);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tercero = new Terceros(rs.getString("id_tercero"),
						               rs.getString("tipo_id"),
								       rs.getString("nombre1"),
									   rs.getString("nombre2"),
									   rs.getString("apellido1"),
									   rs.getString("apellido2"),
									   rs.getString("dir_ppal"),
									   rs.getString("razon_social"),
									   rs.getInt("id_ciudad_ppal"),
									   rs.getString("dir_mail"),
									   rs.getInt("id_ciudad_mail"),
									   rs.getInt("id_zona"),
									   rs.getString("tel_ppal"),
									   rs.getString("tel_oficina"),
									   rs.getString("tel_fax"),
									   rs.getString("tel_otro"),
									   rs.getString("tel_cel1"),
									   rs.getString("tel_cel2"),
									   rs.getString("email1"),
									   rs.getString("email2"),
									   rs.getString("grupo_id"),
									   rs.getString("genero"),
									   rs.getString("path_foto"),
									   rs.getDate("fecha_ingreso"),
									   rs.getDate("fecha_ultcambio"),
									   rs.getString("estado"),
									   rs.getString("id_user_modifico"));
			}
			
			ps.close();
			conexion.close();
			
			if (tercero == null) {
				throw new POSseWSException("Tercero no existe");
			}
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return tercero;
	}
    
    public ArrayList<Terceros> getTerceros() {
		ArrayList<Terceros> lstTerceros = new ArrayList<Terceros>();
		
		String query = "select * from terceros";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstTerceros.add(new Terceros(rs.getString("id_tercero"),
								             rs.getString("tipo_id"),
										     rs.getString("nombre1"),
											 rs.getString("nombre2"),
											 rs.getString("apellido1"),
											 rs.getString("apellido2"),
											 rs.getString("dir_ppal"),
											 rs.getString("razon_social"),
											 rs.getInt("id_ciudad_ppal"),
											 rs.getString("dir_mail"),
											 rs.getInt("id_ciudad_mail"),
											 rs.getInt("id_zona"),
											 rs.getString("tel_ppal"),
											 rs.getString("tel_oficina"),
											 rs.getString("tel_fax"),
											 rs.getString("tel_otro"),
											 rs.getString("tel_cel1"),
											 rs.getString("tel_cel2"),
											 rs.getString("email1"),
											 rs.getString("email2"),
											 rs.getString("grupo_id"),
											 rs.getString("genero"),
											 rs.getString("path_foto"),
											 rs.getDate("fecha_ingreso"),
											 rs.getDate("fecha_ultcambio"),
											 rs.getString("estado"),
											 rs.getString("id_user_modifico")
											));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstTerceros;
	}
    
    public int addTercero(Terceros newTercero) {
    	int Ok = -1;
		
		String query = "insert into terceros (id_tercero, tipo_id, nombre1, nombre2, apellido1, apellido2, razon_social, dir_ppal, id_ciudad_ppal, dir_correo, id_ciudad_correo, "
				+ "id_zona, tel_ppal, tel_oficina, tel_fax, tel_otro, tel_cel1, tel_cel2, email1, email2, grupo_id, genero, path_foto, fecha_ingreso, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conexion = DbConnection.getConnection();
		
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString( 1, newTercero.getIdTercero());
			ps.setString( 2, newTercero.getTipoId());
			ps.setString( 3, newTercero.getNombre1());
			ps.setString( 4, newTercero.getNombre2());
			ps.setString( 5, newTercero.getApellido1());
			ps.setString( 6, newTercero.getApellido2());
			ps.setString( 7, newTercero.getRazonSocial());
			ps.setString( 8, newTercero.getDirPpal());
			ps.setInt   ( 9, newTercero.getIdCiudadPpal());
			ps.setString(10, newTercero.getDirMail());
			ps.setInt   (11, newTercero.getIdCiudadMail());
			ps.setInt   (12, newTercero.getIdZona());
			ps.setString(13, newTercero.getTelPpal());
			ps.setString(14, newTercero.getTelOficina());
			ps.setString(15, newTercero.getTelFax());
			ps.setString(16, newTercero.getTelOtro());
			ps.setString(17, newTercero.getTelCel1());
			ps.setString(18, newTercero.getTelCel2());
			ps.setString(19, newTercero.getEmail1());
			ps.setString(20, newTercero.getEmail2());
			ps.setString(21, newTercero.getGrupoId());
			ps.setString(22, newTercero.getGenero());
			ps.setString(23, newTercero.getPathFoto());
			ps.setDate  (24, newTercero.getFechaIngreso());
			ps.setString(26, "A");
		
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
  
    
    public String armarFullName (Terceros t) {
        String nombres   = (t.getNombre1() == null ? "" : " " + t.getNombre1()) + (t.getNombre2() == null ? "" : " " + t.getNombre2());
        String apellidos = (t.getApellido1() == null ? "" : t.getApellido1()) + (t.getApellido2() == null ? "" : " " + t.getApellido2());
        
        //return t.getRazonSocial() == null ? (apellidos == null ? "" : " " + apellidos) + (nombres == null ? "" : nombres) : t.getRazonSocial();
        return apellidos + nombres;
    }
}
