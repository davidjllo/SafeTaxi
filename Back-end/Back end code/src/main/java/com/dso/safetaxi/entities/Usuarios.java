package com.dso.safetaxi.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuarios {

	// campos de la tabla usuarios
	
    private String username;
    private String password;

    
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuarios(){
    	
    }
    
    public Usuarios(String username, String password) {
        this.username = username;
        this.password = password;

    }

}
