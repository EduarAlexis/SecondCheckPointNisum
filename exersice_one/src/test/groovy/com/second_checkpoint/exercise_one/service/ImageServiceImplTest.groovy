package com.second_checkpoint.exercise_one.service

import com.second_checkpoint.exercise_one.dto.image.Image
import com.second_checkpoint.exercise_one.entity.ImageData
import com.second_checkpoint.exercise_one.repository.ImageRepository
import com.second_checkpoint.exercise_one.util.MapperUtil
import spock.lang.Specification

class ImageServiceImplTest extends Specification{

    private ImageServiceImpl service
    private ImageRepository imageRepository = Stub()

    def setup() {
        service = new ImageServiceImpl()
        service.imageRepository = imageRepository
    }

    def "Find by id" (){
        given:
        Image imageResult
        Image image = new Image(1,"http://imagenMock.com/spockImage.jpg")

        ImageData imageData = MapperUtil.toImageData(image)
        Optional<ImageData> optImage = Optional.of(imageData);

        imageRepository.findById(_) >>> optImage

        when: "Should call findById"
        imageResult = service.findById(1)

        then: "Should return an image"
        imageResult
    }
}
