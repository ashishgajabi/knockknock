package net.readify.knockknock.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Ashish Gajabi
 * Configuration class for Spring with source of all bean definitions from packages
 */
@Component
@Configuration
@ComponentScan(basePackages = { "net.readify.knockknock.api.service.impl" })
public class SpringAppConfiguration {

}
