package com.dso.safetaxi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.safetaxi.dao.DbConnection;
import com.dso.safetaxi.entities.Comments;
import com.dso.safetaxi.entities.Taxis;
import com.dso.safetaxi.exception.POSseWSException;

public class TaxisService {
	
	public String getRating(String taxid) {
		float rating = 0f;
		
		String query = "select rating_avg from taxis where license_id = ?";
		
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

	public Comments getOldRating(String taxid) {
		
		Comments ratingCount = new Comments();
		String query = "select number_ratings, rating_avg from taxis where license_id = ?";
		
		try{
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, taxid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ratingCount = new Comments(rs.getFloat("rating_avg"),
													rs.getInt("number_ratings"));
			}
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return ratingCount;
	}

	public int rateService(String taxid, float rating, String comment) {
		int ok = -1;
		
		String query = "insert into ratings (taxi_id, rating, comment, date) values (?, ?, ?, now())";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, taxid);
			ps.setFloat(2, rating);
			ps.setString(3, comment);
		
			ok = ps.executeUpdate();
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
		
		return ok;
	}

	public int updateAvg(String taxid, float rating, Comments oldRate) {
		int Ok = -1;
		int rCount = oldRate.getRateCount();
		float div1 = (float) (rCount / (rCount + 1.0));
		float div2 = (float) (1.0 / (rCount + 1.0));
		float ratingCalc = oldRate.getRating() * div1 + rating * div2;
		String query = "update taxis set rating_avg = ?, number_ratings = ? " +
					   "where license_id = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setFloat(1, ratingCalc);
			ps.setInt(2, rCount + 1);
			ps.setString(3, taxid);
		 
		
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

	public Taxis getTaxi(String hash) {
		
		Taxis taxi = new Taxis();
		String query = "select * from taxis where license_id = ?";
		
		try{
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, hash);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				taxi = new Taxis(rs.getInt("license_id"),
					    		 rs.getInt("model"),
					    		 rs.getString("make"),
					    		 rs.getFloat("rating_avg"),
					    		 rs.getInt("number_ratings"));
			}
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return taxi;
	}
	
}
