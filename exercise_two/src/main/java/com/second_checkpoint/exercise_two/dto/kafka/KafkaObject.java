package com.second_checkpoint.exercise_two.dto.kafka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class KafkaObject implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String message;
    @JsonCreator
    public KafkaObject(@JsonProperty("id") String id,
                       @JsonProperty("message") String message) {
        super();
        this.id = id;
        this.message = message;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }
}