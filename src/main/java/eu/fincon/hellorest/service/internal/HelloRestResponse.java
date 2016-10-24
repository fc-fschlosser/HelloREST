package eu.fincon.hellorest.service.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class HelloRestResponse {

    private long id;

    @Length(max = 3)
    private String content;

    public HelloRestResponse() {
        // Jackson deserialization
    }

    public HelloRestResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
	
}