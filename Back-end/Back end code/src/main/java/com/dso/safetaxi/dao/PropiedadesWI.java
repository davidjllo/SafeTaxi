package com.dso.safetaxi.dao;

import java.io.InputStream;
import java.util.Properties;

public class PropiedadesWI {
	
	public String connectionURL;
	public String ClassforName;
	public String userDB;
	public String passwordDB;
	
	public void ParametrosWI() throws Exception {
		Properties propiedades = new Properties();
	    
		InputStream entrada = getClass().getClassLoader().getResourceAsStream("wi.properties");
	    if (entrada != null) {
	    	propiedades.load(entrada);
	    	entrada.close();
	    } else {
	    	System.out.println("Archivo de propiedades wi.properties no existe");
	    	throw new RuntimeException("Archivo de propiedades wi.properties no existe");
	    }
	    
	    connectionURL = propiedades.getProperty("connectionURL");
        ClassforName = propiedades.getProperty("ClassforName");
        userDB = propiedades.getProperty("userDB");
        passwordDB = propiedades.getProperty("passwordDB");
	}
}
