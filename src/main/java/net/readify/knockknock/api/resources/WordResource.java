package net.readify.knockknock.api.resources;

import javax.ws.rs.GET;
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

import net.readify.knockknock.api.service.WordManipulation;

/**
 * @author Ashish Gajabi
 * Resource class for word resource. Path variable is case insensitive
 *
 */
@Path("{reverseWords:[Rr][Ee][Vv][Ee][Rr][Ss][Ee][Ww][Oo][Rr][Dd][Ss]}")
@Produces(MediaType.APPLICATION_JSON)
public class WordResource {
	
	@Autowired
	private WordManipulation wordManipulation;

	@GET
	public final Response getReverseWord(
			final @QueryParam ("sentence") String sentence) {
		ObjectMapper objectMapper = new ObjectMapper();
		Response res = null;
		
		try {
			res = Response
					.status(Status.OK)
					.cacheControl(CacheControl.valueOf("no-cache"))
					.expires(null)
					.header("Content-Type", "application/json; charset=utf-8")
					.entity(objectMapper.writeValueAsString(wordManipulation.wordReversal(sentence)))
					.build();
		} catch (JsonProcessingException e) {
			res = Response.status(Status.INTERNAL_SERVER_ERROR).build();
			e.printStackTrace();
		}
		return res;
	}

}
