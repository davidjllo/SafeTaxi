package com.dso.safetaxi.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.safetaxi.entities.Comments;
import com.dso.safetaxi.entities.Taxis;
import com.dso.safetaxi.services.TaxisService;

@Path("/taxis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaxisResource {

	TaxisService taxisService = new TaxisService();
	
	@GET
	@Path("/placas/{hash}")
	//Function in charged of returning the current rating of a vehicle given a licenseId
	public String getRating (@PathParam("hash") String hash) {
		return taxisService.getRating(hash);
	}
	
	@POST
	@Path("/rate/{taxid}/{rating}/{comment}")
	@Produces("text/plain")
	/*Function in charged of adding the current report to a historical of the taxi
	  and updating the taxi table with the new average calculated */ 
	public String rateTaxi (@PathParam("taxid") String taxid,
							@PathParam("rating") float rating,
							@PathParam("comment") String comment) {
		String message = "N";
		Comments oldRate = taxisService.getOldRating(taxid);
		if(taxisService.rateService(taxid, rating, comment) != -1){
			if(taxisService.updateAvg(taxid, rating, oldRate) != -1){
				//message = "succes updating avg";
				message = "S";
			}
		}
		return message;	
	}
	
	@GET
	@Path("/{hash}")
	//Function in charged of returning all data relevant to a given licenseId
	public Taxis getTaxi (@PathParam("hash") String hash) {
		return taxisService.getTaxi(hash);
	}
	
	
	
}
