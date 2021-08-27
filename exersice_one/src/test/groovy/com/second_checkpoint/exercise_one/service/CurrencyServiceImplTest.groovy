package com.second_checkpoint.exercise_one.service

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto
import com.second_checkpoint.exercise_one.dto.image.Image
import com.second_checkpoint.exercise_one.dto.item.Item
import com.second_checkpoint.exercise_one.entity.CurrencyData
import com.second_checkpoint.exercise_one.repository.CurrencyRepository
import com.second_checkpoint.exercise_one.util.MapperUtil
import spock.lang.Specification
import spock.lang.Subject

class CurrencyServiceImplTest extends Specification {

    private CurrencyServiceImpl service
    private CurrencyRepository currencyRepository = Stub()

    @Subject
    CurrencyDto currency = getCurrencyDto()
    @Subject
    CurrencyData currencyData = MapperUtil.toCurrencyData(currency)
    @Subject
    Optional<CurrencyData> optCurrency = Optional.of(currencyData);


    def setup() {
        service = new CurrencyServiceImpl()
        service.currencyRepository = currencyRepository
    }

    def "Find currency by code"() {
        given: "Currency code"
        currencyRepository.findByCode(_) >> currencyData

        when:"Should find by code in BD"
        CurrencyDto currency = service.findByCode("CLP")

        then:"Should return currency"
        currency
    }

    def "Find currency by currency id"() {
        given: "Currency id"
        currencyRepository.findById(_) >> optCurrency

        when:"Should find by currency id in BD"
        CurrencyDto currency = service.findByCurrencyId(1)

        then:"Should return currency"
        currency
    }

    def "Should update by currency data"() {
        given: "Currency code"
        currencyRepository.save(_) >> currencyData

        when:"Should find code in BD"
        CurrencyDto currency = service.updateCurrency(currencyData)

        then:"Should return currency"
        currency
    }

    def getItem() {
        return new Item(1, "1234", "ipad", 200, 1, "", "http://ishop.com/ipad2021.jpg", new ArrayList<Image>())
    }

    def getCurrencyDto() {
        List<Item> listItem =  new ArrayList<Item>()
        listItem.add(getItem())
        return new CurrencyDto(1, "CLP", '$', listItem)
    }
}
