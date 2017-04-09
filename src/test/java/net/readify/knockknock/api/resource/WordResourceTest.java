package net.readify.knockknock.api.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import net.readify.knockknock.api.config.JerseyApiResourceConfig;
import net.readify.knockknock.api.config.SpringAppConfiguration;

public class WordResourceTest extends JerseyTest{

	@Override
	protected Application configure() {
		// Spring App configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringAppConfiguration.class);
        context.refresh();

        // Jersey App configuration
        MockServletContext mockServletContext = new MockServletContext();
        mockServletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);

        JerseyApiResourceConfig config = new JerseyApiResourceConfig(mockServletContext);
        config.property("contextConfig", context);
        return config;
	}
	

	//@Test
	public void testGetReverseWord() {
		
		Response res = 
				target("{reverseWords:[Rr][Ee][Vv][Ee][Rr][Ss][Ee][Ww][Oo][Rr][Dd][Ss]}").resolveTemplate("reverseWords", "reverseWords").queryParam("sentence", "ABC").request().get();
		assertEquals("CBA", res.readEntity(String.class));
	}

}
