package com.second_checkpoint.exercise_one.controller

import com.second_checkpoint.exercise_one.dto.image.Image
import com.second_checkpoint.exercise_one.dto.item.Item
import com.second_checkpoint.exercise_one.dto.item.ItemApiResponse
import com.second_checkpoint.exercise_one.dto.item.ItemRequest
import com.second_checkpoint.exercise_one.dto.item.ItemUpdateRequest
import com.second_checkpoint.exercise_one.dto.kafka.KafkaObject
import com.second_checkpoint.exercise_one.producer.ProducerService
import com.second_checkpoint.exercise_one.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ItemControllerTest  extends Specification {

    private ItemController itemController
    private ItemService itemService = Stub()
    private ProducerService producerService = Stub()

    def setup() {
        this.itemController = new ItemController()
        this.itemController.itemService = itemService
        this.itemController.producerService = producerService
    }

    def "Should add a new item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemApiResponse res = new ItemApiResponse(1,"success")
        itemService.add(req) >>> getItem()
        KafkaObject k = new KafkaObject()
        k.setId("1")
        k.setMessage("new")
        producerService.sendMessage(k)
        itemController.add(req) >>> res

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.add(req)

        then: "Result test"
        result.getStatusCode() == HttpStatus.OK
        result.getBody() == res
    }

    def "Should return bad request when try to add a new item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemApiResponse res = new ItemApiResponse()

        itemService.add(req) >>> null
        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.add(req)

        then: "Result test"
        result.getStatusCode() == HttpStatus.BAD_REQUEST
    }

    def "Should update an item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()

        ItemApiResponse res = new ItemApiResponse(1,"success")
        itemService.updateItem(_, _) >>> getItem()
        KafkaObject k = new KafkaObject()
        k.setId("1")
        k.setMessage("new")
        producerService.sendMessage(k)
        itemService.add(_) >>> res

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.updateItem(1, getItemUpdateRequest())

        then: "Result test"
        result.getStatusCode() == HttpStatus.OK
        result.getBody() == res
    }

    def "Should return bad request when try to update an item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemUpdateRequest updateReq = new ItemUpdateRequest()
        ItemApiResponse res = new ItemApiResponse(null, "Error")
        itemService.updateItem(_,_) >>> null

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.updateItem(null, updateReq)

        then: "Result test"
        result.getStatusCode() == HttpStatus.BAD_REQUEST
        result.getBody().getId() == res.getId()
        result.getBody().getMessage() == res.getMessage()
    }

    def "Should get an item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemUpdateRequest updateReq = new ItemUpdateRequest()

        ItemApiResponse res = new ItemApiResponse(1,"success")
        itemService.updateItem(1, updateReq) >>> getItem()
        KafkaObject k = new KafkaObject()
        k.setId("1")
        k.setMessage("new")
        producerService.sendMessage(k)
        itemController.add(_) >>> res

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.updateItem(1, updateReq)

        then: "Result test"
        result.getStatusCode() == HttpStatus.OK
        result.getBody() == res
    }

    def "Should return bad request when try to get an item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemApiResponse res = new ItemApiResponse(null, "Bad Request")
        itemService.getById(_) >>> null

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.getItem(-1)

        then: "Result test"
        result.getStatusCode() == HttpStatus.BAD_REQUEST
        result.getBody() == res
    }

    def "Should return not found when try to get an item"() {

        given: "Conditions"
        ItemRequest req = new ItemRequest()
        ItemApiResponse res = new ItemApiResponse(null, "Item not found")
        itemService.getById(_) >>> new Item()

        when: "Function execute"
        ResponseEntity<ItemApiResponse> result = itemController.getItem(2)

        then: "Result test"
        result.getStatusCode() == HttpStatus.NOT_FOUND
        result.getBody() == res
    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }

    def getItemUpdateRequest(){
        return new ItemUpdateRequest("1234", "ipad", 400, "CLP", "httpS://ishop.com/ipad2021.jpg", "Update ipad price")
    }

}
