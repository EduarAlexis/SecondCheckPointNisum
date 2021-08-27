package com.second_checkpoint.exercise_one.service

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto
import com.second_checkpoint.exercise_one.dto.image.Image
import com.second_checkpoint.exercise_one.dto.item.Item
import com.second_checkpoint.exercise_one.dto.item.ItemRequest
import com.second_checkpoint.exercise_one.dto.item.ItemUpdateRequest
import com.second_checkpoint.exercise_one.entity.ItemData
import com.second_checkpoint.exercise_one.repository.ItemRepository
import com.second_checkpoint.exercise_one.util.MapperUtil
import spock.lang.Specification

class ItemServiceImplTest extends Specification {

    private ItemServiceImpl itemServiceImpl
    private ItemRepository itemRepository = Stub()
    private CurrencyService currencyService = Stub()
    private ImageService imageService = Stub()

    void setup() {
        itemServiceImpl = new ItemServiceImpl()
        itemServiceImpl.itemRepository = itemRepository
        itemServiceImpl.currencyService = currencyService
        itemServiceImpl.imageService = imageService
    }

    def "Add Item"() {
        given:
        Item itemResult
        ItemRequest itemRequest = getItemRequest()
        Item item = getItem()

        ItemData itemData = MapperUtil.toItemData(item)
        CurrencyDto currencyDto = getCurrencyDto()

        currencyService.findByCode(itemRequest.getCurrency()) >>> currencyDto
        itemRepository.save(_) >>> itemData

        when: "Call findByCode and save Item"
        itemResult = itemServiceImpl.add(itemRequest)

        then:
        itemResult
    }

    def "Add Item with error"() {
        given:
        Item itemResult
        ItemRequest itemRequest = getItemRequest()

        currencyService.findByCode(itemRequest.getCurrency()) >>> null

        when: "Call findByCode and save Item"
        itemResult = itemServiceImpl.add(itemRequest)

        then: "Should return null"
        itemResult == null
    }

    def "Throw IllegalArgumentException "() {
        given:
        Item itemResult
        currencyService.findByCode(_) >>> { new NullPointerException () }

        when: "Call findByCode and save Item"
        itemResult = itemServiceImpl.add(null)

        then: "Should return null"
        thrown(NullPointerException)
    }

    def "Get item by id"(){
        given:
        Item itemResult
        ItemRequest itemRequest = getItemRequest()
        Item item = getItem()

        ItemData itemData = MapperUtil.toItemData(item)
        Optional<ItemData> optItem = Optional.of(itemData)

        itemRepository.findById(item.getId()) >>> optItem

        when: "Call findById"
        itemResult = itemServiceImpl.getById(1)

        then:
        itemResult
    }

    def "Update Item"(){
        given:
        Item itemResult
        ItemRequest itemRequest = getItemRequest()
        Item item = getItem()

        ItemData itemData = MapperUtil.toItemData(item)
        Optional<ItemData> optItem = Optional.of(itemData);

        CurrencyDto currencyDto = getCurrencyDto()

        itemRepository.findById(item.getId()) >>> optItem
        currencyService.findByCode(itemRequest.getCurrency()) >>> currencyDto
        currencyService.findByCurrencyId(_) >>> currencyDto
        itemRepository.save(_) >>> itemData

        when: "Call findById"
        itemResult = itemServiceImpl.updateItem(1, getItemUpdateRequest())

        then:
        itemResult
    }

    def getItemRequest() {
        return new ItemRequest("1234", "ipad", 200, "CLP", "http://ishop.com/ipad2021.jpg")
    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }

    def getCurrencyDto() {
        List<Item> listItem =  new ArrayList<Item>()
        listItem.add(getItem())
        return new CurrencyDto(1, "CLP", '$', listItem)
    }

    def getItemUpdateRequest(){
        return new ItemUpdateRequest("1234","ipad",200,"CLP","http://ishop.com/ipad2021.jpg", "Update image")
    }
}

