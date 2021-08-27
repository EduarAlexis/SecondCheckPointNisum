package com.second_checkpoint.exercise_two.consumer;

import com.second_checkpoint.exercise_two.client.Client;
import com.second_checkpoint.exercise_two.dto.item.Item;
import com.second_checkpoint.exercise_two.dto.kafka.KafkaObject;
import com.second_checkpoint.exercise_two.service.ItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    ItemServiceImpl service;

    @Autowired
    Client clientHttp;

    @KafkaListener(topics = "items-update", groupId = "group_id")
    public void consume(KafkaObject message) {
        logger.info(String.format("Consumed message: %s", message.getMessage()));
        Item item = clientHttp.getItem(message.getId());
        if (message.getMessage().equals("update")) {
            service.update(item);
        } else {
            service.save(item);
        }
    }
}