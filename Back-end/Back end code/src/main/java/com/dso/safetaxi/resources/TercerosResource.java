package com.dso.safetaxi.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.safetaxi.entities.Terceros;
import com.dso.safetaxi.services.TercerosService;

@Path("/terceros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TercerosResource {
	
	TercerosService tercerosService = new TercerosService();
	
	@GET
	@Path("/{idTercero}")
	public String getTercero (@PathParam("idTercero") String idTercero) {
		return tercerosService.armarFullName(tercerosService.getTercero(idTercero));
	}
	
	@GET
	public ArrayList<Terceros> getTerceros() {
		ArrayList<Terceros> lst = new ArrayList<Terceros>();
		lst = tercerosService.getTerceros();
		return lst;
	}
	
	@POST
	public String addTercero (Terceros newTercero) {
		String opResult = null;
				
		if (tercerosService.addTercero(newTercero) == -1) {
			opResult = "FALLO";
		} else opResult = "OK";
		
		return opResult;
	}
	
}
