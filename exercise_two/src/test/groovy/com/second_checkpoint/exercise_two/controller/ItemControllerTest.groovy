package com.second_checkpoint.exercise_two.controller

import com.second_checkpoint.exercise_two.dto.image.Image
import com.second_checkpoint.exercise_two.dto.item.Item
import com.second_checkpoint.exercise_two.service.ItemServiceImpl
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ItemControllerTest extends Specification {

    private ItemController controller
    private ItemServiceImpl service = Stub()

    def setup(){
        controller = new ItemController()
        controller.service = service
    }

    def "Should search item by id"(){
        given:
        service.findById(_) >>> getItem()

        when:
        ResponseEntity<?> response = controller.getItem(1)

        then:
        response
    }

    def "Should get item by id and return null"(){
        given:
        service.findById(_) >>> null

        when:
        ResponseEntity<?> response = controller.getItem(null)

        then:
        response
    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }
}
