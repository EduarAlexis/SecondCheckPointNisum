package com.second_checkpoint.exercise_two.services

import com.second_checkpoint.exercise_two.dto.image.Image
import com.second_checkpoint.exercise_two.dto.item.Item
import com.second_checkpoint.exercise_two.entity.ItemData
import com.second_checkpoint.exercise_two.repository.ItemRepository
import com.second_checkpoint.exercise_two.service.ImageService
import com.second_checkpoint.exercise_two.service.ItemServiceImpl
import com.second_checkpoint.exercise_two.util.MapperUtil
import spock.lang.Specification

class ItemServiceImplTest extends Specification {

    private ItemServiceImpl service;
    private ItemRepository repository = Stub()
    private ImageService imageService = Stub()

    def setup() {
        service = new ItemServiceImpl()
        service.repository = repository
        service.imageService = imageService
    }

    def "Should save an item"() {
        given:
        repository.save(_) >>> MapperUtil.toItemData(getItem())

        when: "Call save item"
        Item itemResponse = service.save(getItem())

        then: "Check item retorned"
        itemResponse
    }

    def "Should update item"() {
        given:
        repository.save(_) >>> MapperUtil.toItemData(getItem())

        when:
        Item itemResponse = service.update(getItem())

        then:
        itemResponse
    }

    def "Should find item by id"() {
        given:
        ItemData itemData = MapperUtil.toItemData(getItem())
        Optional<ItemData> optItem = Optional.of(itemData)
        repository.findById(_) >>> optItem
        imageService.findById(_) >>> new Image(1,"http://image.com/image.jpg")
        when:
        Item itemResponse = service.findById(getItem().getId())

        then:
        itemResponse
    }

    def "Should return null"() {
        given:
        repository.findById(_) >>> null

        when:
        Item itemResponse = service.findById(null)

        then:
        itemResponse == null
    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }
}
