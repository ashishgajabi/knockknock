package net.readify.knockknock.api.exception.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import net.readify.knockknock.api.model.ErrorMessage;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Context UriInfo uriInfo;
	
	@Override
	public Response toResponse(NotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("No HTTP resource was found that matches the request URI '"+uriInfo.getRequestUri() +"'.");
		return Response.status(Status.NOT_FOUND)
				.header("Content-Type", "application/json; charset=utf-8")
				.entity(errorMessage)
				.build();
	}

}
