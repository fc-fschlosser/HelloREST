package eu.fincon.hellorest.service;

import eu.fincon.hellorest.service.internal.HelloConfiguration;
import eu.fincon.hellorest.service.internal.TemplateHealthCheck;
import eu.fincon.hellorest.service.provider.HelloEndpoint;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloApplication extends Application<HelloConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloConfiguration configuration,
                    Environment environment) {
    	
    	final HelloEndpoint resource = new HelloEndpoint(
    			configuration.getTemplate(), 
    			configuration.getDefaultName());
    	
    	final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
    			configuration.getTemplate());
    	
    	environment.healthChecks().register("template", healthCheck);
    	environment.jersey().register(resource);
        // nothing to do yet
    }

}