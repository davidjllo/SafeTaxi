package com.dso.safetaxi.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.safetaxi.entities.Taxis;
import com.dso.safetaxi.services.TaxisService;

@Path("/taxis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaxisResource {

	TaxisService taxisService = new TaxisService();
	
	@GET
	@Path("/placas/{hash}")
	public String getRating (@PathParam("hash") String hash) {
		return taxisService.getRating(hash);
	}
	
	
}
