package com.second_checkpoint.exercise_two.config;

import com.second_checkpoint.exercise_two.dto.kafka.KafkaObject;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, KafkaObject> consumerFactory() {
        JsonDeserializer<KafkaObject> jsondDeserializer = new JsonDeserializer<>(KafkaObject.class);
        jsondDeserializer.setRemoveTypeHeaders(false);
        jsondDeserializer.addTrustedPackages("*");
        jsondDeserializer.setUseTypeMapperForKey(true);

        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, jsondDeserializer);
        configProps.put(jsondDeserializer.TRUSTED_PACKAGES, "*");

        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), jsondDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaObject> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaObject> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}