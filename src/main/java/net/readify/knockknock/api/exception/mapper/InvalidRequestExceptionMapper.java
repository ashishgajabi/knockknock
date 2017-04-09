package net.readify.knockknock.api.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import net.readify.knockknock.api.exception.InvalidRequestException;

@Provider
@Component
public class InvalidRequestExceptionMapper implements ExceptionMapper<InvalidRequestException> {

	@Override
	public Response toResponse(InvalidRequestException e) {
		return Response.status(Status.BAD_REQUEST)
				.header("Content-Type", "application/json; charset=utf-8")
				.entity(e.getErrorMessage())
				.build();
	}

}
