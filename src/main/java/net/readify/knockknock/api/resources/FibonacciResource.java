package net.readify.knockknock.api.resources;

import javax.ws.rs.BadRequestException;
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
import net.readify.knockknock.api.service.FibonacciService;


/**
 * @author Ashish Gajabi
 * Resource class for fibonacci. Path variable is case insensitive
 */
@Path("{fibonacci:[Ff][Ii][Bb][Oo][Nn][Aa][Cc][Cc][Ii]}")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {
	
	@Autowired
	private FibonacciService fibonacciService;
	
	@GET
	public final Response getNthFibonacciNum(final @QueryParam("n") String n) throws InvalidRequestException {
		if (n == null)
		{
			throw new NotFoundException();
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		Response res = null;
		int x;
		try
		{
			x = Integer.parseInt(n);
		}
		catch (NumberFormatException e)
		{
			throw new InvalidRequestException("The request is invalid.");
		}
		String result = fibonacciService.getNthFibonacciNum(x);
		try {
			if (result == null) {
				throw new BadRequestException();
			}
			res = Response
					.status(Status.OK)
					.cacheControl(CacheControl.valueOf("no-cache"))
					.expires(null)
					.header("Content-Type", "application/json; charset=utf-8")
					.entity(objectMapper.writeValueAsString(result))
					.build();
		} catch (JsonProcessingException e) {
			res = Response.status(Status.INTERNAL_SERVER_ERROR).build();
			e.printStackTrace();
		}
		return res;
	}
}
