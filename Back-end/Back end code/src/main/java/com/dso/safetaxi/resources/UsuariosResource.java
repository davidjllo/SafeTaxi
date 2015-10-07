package com.dso.safetaxi.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.safetaxi.entities.Usuarios;
import com.dso.safetaxi.services.UsuariosService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosResource {
	
	UsuariosService usuariosService = new UsuariosService();
	
	@GET
	@Path("/{username}")
	public Usuarios getUsuario (@PathParam("username") String username) {
		return usuariosService.getUsuario(username);
	}
	
	@GET
	public ArrayList<Usuarios> getUsuarios() {
		ArrayList<Usuarios> lst = new ArrayList<Usuarios>();		
		lst = usuariosService.getUsuarios();
		return lst;
	}
	
	@GET
	@Path("/{username}/{password}")
	public String getUsuarioValido (@PathParam("username") String username, @PathParam("password") String password) {
		Usuarios usuario = usuariosService.getUsuario(username);
		if (usuario == null) {
			return "N";
		} 
		
		if (usuario.getPassword().equals(password)) {
			return "S";
		} else return "N";
	}
	
	@POST
	@Path("/addUsuario")
	public String addUsuario (Usuarios newUsuario) {
		String opResult = null;
		
		if (usuariosService.addUsuario(newUsuario) == -1) {
			opResult = "FALLO";
		} else opResult = "OK";
		
		return opResult;
	}
       
	
}
