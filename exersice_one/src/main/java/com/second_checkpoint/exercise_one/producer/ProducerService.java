package com.second_checkpoint.exercise_one.producer;

import com.second_checkpoint.exercise_one.dto.kafka.KafkaObject;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    KafkaTemplate<String, KafkaObject> kafkaTemplate;
    private final String TOPIC = "items-update";

    public void sendMessage(KafkaObject message) {
        logger.info(String.format("$$$$ => Producing message: %s", message));

        ListenableFuture<SendResult<String, KafkaObject>> future = this.kafkaTemplate.send(TOPIC, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send message: %s", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, KafkaObject> result) {
                logger.info("Sent message:  %s", message, result.getRecordMetadata().offset());
            }
        });
    }
}