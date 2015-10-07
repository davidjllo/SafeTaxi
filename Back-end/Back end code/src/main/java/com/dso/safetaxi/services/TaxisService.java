package com.dso.safetaxi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.safetaxi.dao.DbConnection;
import com.dso.safetaxi.entities.Taxis;
import com.dso.safetaxi.exception.POSseWSException;

public class TaxisService {
	
	public String getRating(String taxid) {
		float rating = 0f;
		
		String query = "select rating_avg from taxis where placa_id = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, taxid); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rating = rs.getFloat("rating_avg");
			}
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		return String.valueOf(rating);
	}
	
}
