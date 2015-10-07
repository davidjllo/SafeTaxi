package com.dso.safetaxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() {
		PropiedadesWI propiedades = new PropiedadesWI();
		
		try {
			propiedades.ParametrosWI();
			
			Connection connection = null;
			Class.forName(propiedades.ClassforName).newInstance();
			connection = DriverManager.getConnection(propiedades.connectionURL, propiedades.userDB, propiedades.passwordDB);
		    connection.setAutoCommit(false);
			return connection;
		} catch (RuntimeException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}