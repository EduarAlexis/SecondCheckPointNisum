package com.second_checkpoint.exercise_one.service;

import com.second_checkpoint.exercise_one.dto.image.Image;
import com.second_checkpoint.exercise_one.repository.ImageRepository;
import com.second_checkpoint.exercise_one.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image findById(Integer id) {
        try{
            return MapperUtil.toImage(imageRepository.findById(id).get());
        }catch (NoSuchElementException e){
            logger.info("Not found, image with id "+ id);
        }
        return null;
    }
}
