package com.dso.safetaxi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.dso.safetaxi.entities.ErrorMessage;

@Provider
public class POSseWSExceptionMapper implements ExceptionMapper<POSseWSException> {

	@Override
	public Response toResponse(POSseWSException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "ver error 400 en http://dso.com.co");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}
