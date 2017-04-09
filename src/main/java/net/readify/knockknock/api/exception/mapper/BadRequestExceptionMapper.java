package net.readify.knockknock.api.exception.mapper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

	@Override
	public Response toResponse(BadRequestException e) {
		return Response.status(Status.BAD_REQUEST)
				.header("Content-Type", "application/json; charset=utf-8")
				.entity("")
				.build();
	}

}
