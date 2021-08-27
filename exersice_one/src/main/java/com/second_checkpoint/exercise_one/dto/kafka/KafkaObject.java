package com.second_checkpoint.exercise_one.dto.kafka;

import lombok.Data;

@Data
public class KafkaObject {
    /*@JsonCreator
    public KafkaObject(@JsonProperty("id") String id,
                       @JsonProperty("message") String message) {
        super();
        this.id = id;
        this.message = message;
    }*/

    private String id;
    private String message;
}
