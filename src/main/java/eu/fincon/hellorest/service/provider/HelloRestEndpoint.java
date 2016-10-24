package eu.fincon.hellorest.service.provider;

import com.codahale.metrics.annotation.Timed;

import eu.fincon.hellorest.service.internal.HelloRestResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloRestEndpoint {
	
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloRestEndpoint(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public HelloRestResponse sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new HelloRestResponse(counter.incrementAndGet(), value);
    }
}
