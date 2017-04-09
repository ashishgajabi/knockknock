package net.readify.knockknock.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.readify.knockknock.api.service.TokenService;

/**
 * @author Ashish Gajabi
 * Resource class for Token. Path variable is case insensitive
 *
 */
@Path("{token:[Tt][Oo][Kk][Ee][Nn]}")
@Produces(MediaType.APPLICATION_JSON)
public class TokenResource {
	
	@Autowired
	private TokenService tokenService;
	
	@GET
	public final Response getToekn() {
		ObjectMapper objectMapper = new ObjectMapper();
		Response res = null;
		
		try {
			res = Response
					.status(Status.OK)
					.cacheControl(CacheControl.valueOf("no-cache"))
					.expires(null)
					.header("Content-Type", "application/json; charset=utf-8")
					.entity(objectMapper.writeValueAsString(tokenService.getSelfToken()))
					.build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			res = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return res;
	}

}
