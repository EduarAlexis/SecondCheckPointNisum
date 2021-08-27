package com.second_checkpoint.exercise_one.producer

import com.second_checkpoint.exercise_one.dto.item.ItemApiResponse
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.util.concurrent.ListenableFuture
import spock.lang.Specification

class ProducerServiceTest extends Specification {

    private ProducerService service
    private KafkaTemplate kafkaTemplate = Mock(KafkaTemplate.class)
    private ListenableFuture listenableFuture = Mock(ListenableFuture.class)

    def setup () {
        service = new ProducerService()
        service.kafkaTemplate = kafkaTemplate
    }

    def "Should send a messagge"(){
        given:
        ItemApiResponse message = new ItemApiResponse(1,"success")
        kafkaTemplate.send(_,_) >>> listenableFuture

        when: "Should send messagge"

        then:
        kafkaTemplate.send("items-update",message)
    }
}
