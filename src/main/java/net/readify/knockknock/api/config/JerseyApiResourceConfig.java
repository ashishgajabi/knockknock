package net.readify.knockknock.api.config;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Ashish Gajabi
 * Jersey configuration class with package containing all resources
 */
@ApplicationPath("/*")
public class JerseyApiResourceConfig extends ResourceConfig {

	public JerseyApiResourceConfig(@Context ServletContext context) {
		packages("net.readify.knockknock.api.resource");
	}

}
