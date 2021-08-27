package com.second_checkpoint.exercise_two.consumer

import com.second_checkpoint.exercise_two.dto.kafka.KafkaObject
import com.second_checkpoint.exercise_two.client.Client
import com.second_checkpoint.exercise_two.dto.image.Image
import com.second_checkpoint.exercise_two.dto.item.Item
import com.second_checkpoint.exercise_two.service.ItemServiceImpl
import spock.lang.Specification

class ConsumerServiceTest extends Specification {

    private ConsumerService consumerService
    private ItemServiceImpl itemService = Stub()
    private Client clientHttp = Stub()

    def setup(){
        consumerService = new ConsumerService()
        consumerService.service = itemService
        consumerService.clientHttp = clientHttp
    }

    def "Should consume a messagge and update item"(){
        when:
        KafkaObject message = new KafkaObject("1","update")
        clientHttp.getItem(message.getId()) >>> getItem()

        then: "Call a consume method"
        consumerService.consume(message)

    }

    def "Should consume a messagge and save item"(){
        when:
        KafkaObject message = new KafkaObject("1","new")
        clientHttp.getItem(message.getId()) >>> getItem()

        then: "Call a consume method"
        consumerService.consume(message)

    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }
}
