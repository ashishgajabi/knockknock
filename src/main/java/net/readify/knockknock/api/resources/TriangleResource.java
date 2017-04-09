package net.readify.knockknock.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.readify.knockknock.api.exception.InvalidRequestException;
import net.readify.knockknock.api.service.TriangleType;

/**
 * @author Ashish Gajabi
 * Resource class for triangle type. Path variable is case insensitive
 *
 */
@Path("{triangleType:[Tt][Rr][Ii][Aa][Nn][Gg][Ll][Ee][Tt][Yy][Pp][Ee]}")
@Produces(MediaType.APPLICATION_JSON)
public class TriangleResource {
	
	@Autowired
	private TriangleType triangleType;

	@GET
	public final Response getTriangleType (
			final @QueryParam("a") String a, 
			final @QueryParam("b") String b, 
			final @QueryParam("c") String c) throws InvalidRequestException {
		
		if (a == null || b == null || c == null)
		{
			throw new NotFoundException();
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		Response res = null;
		
		int x, y, z;
		
		try
		{
			x = Integer.parseInt(a);
			y = Integer.parseInt(b);
			z = Integer.parseInt(c);
		}
		catch (NumberFormatException e)
		{
			throw new InvalidRequestException("The request is invalid.");
		}
		
		try {
			res = Response
					.status(Status.OK)
					.cacheControl(CacheControl.valueOf("no-cache"))
					.expires(null)
					.header("Content-Type", "application/json; charset=utf-8")
					.entity(objectMapper.writeValueAsString(triangleType.getTriangleType(x, y, z)))
					.build();
		} catch (JsonProcessingException e) {
			res = Response.status(Status.INTERNAL_SERVER_ERROR).build();
			e.printStackTrace();
		}
		return res;
	}	
}
