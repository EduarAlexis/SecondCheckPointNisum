package com.second_checkpoint.exercise_two.services

import com.second_checkpoint.exercise_two.dto.image.Image
import com.second_checkpoint.exercise_two.entity.ImageData
import com.second_checkpoint.exercise_two.entity.ItemData
import com.second_checkpoint.exercise_two.repository.ImageRepository
import com.second_checkpoint.exercise_two.service.ImageServiceImpl
import com.second_checkpoint.exercise_two.util.MapperUtil
import spock.lang.Specification

class ImageServiceImplTest  extends Specification {

    private ImageServiceImpl service
    private ImageRepository repository = Stub()

    def setup(){
        service = new ImageServiceImpl()
        service.repository = repository
    }

    def "Should save an image"() {
        given:
        repository.save(_) >>> MapperUtil.toImageData(getImage())

        when: "Call save image"
        Image imageResponse = service.save(getImage())

        then: "Check item retorned"
        imageResponse
    }

    def "Should update image"() {
        given:
        repository.save(_) >>> MapperUtil.toImageData(getImage())

        when:
        Image imageResponse = service.update(getImage())

        then:
        imageResponse
    }

    def "Should find image by id"() {
        given:
        ImageData imageData = MapperUtil.toImageData(getImage())
        Optional<ImageData> optImage = Optional.of(imageData)
        repository.findById(_) >>> optImage

        when:
        Image imageResponse = service.findById(getImage().getItemId())

        then:
        imageResponse
    }

    def getImage() {
        return new Image(1, "http://ishop.com/ipad2021.jpg")
    }
}
