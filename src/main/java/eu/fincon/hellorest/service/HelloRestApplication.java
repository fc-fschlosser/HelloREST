package eu.fincon.hellorest.service;

import eu.fincon.hellorest.service.internal.HelloRestConfiguration;
import eu.fincon.hellorest.service.internal.TemplateHealthCheck;
import eu.fincon.hellorest.service.provider.HelloRestEndpoint;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloRestApplication extends Application<HelloRestConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloRestApplication().run(args);
	}

	@Override
	public String getName() {
		return "helloREST";
	}

	@Override
	public void initialize(Bootstrap<HelloRestConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(HelloRestConfiguration configuration, Environment environment) {

		final HelloRestEndpoint resource = new HelloRestEndpoint(configuration.getTemplate(), configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		// nothing to do yet
	}

}