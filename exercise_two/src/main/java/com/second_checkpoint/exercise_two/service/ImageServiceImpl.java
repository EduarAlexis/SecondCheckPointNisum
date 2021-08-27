package com.second_checkpoint.exercise_two.service;

import com.second_checkpoint.exercise_two.dto.image.Image;
import com.second_checkpoint.exercise_two.repository.ImageRepository;
import com.second_checkpoint.exercise_two.util.MapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    public ImageRepository repository;

    @Override
    public Image save(Image image) {
        return MapperUtil.toImage(repository.save(MapperUtil.toImageData(image)));
    }

    @Override
    public Image update(Image image) {
        Image imageUpdate = findById(image.getItemId());
        if (imageUpdate != null)
            imageUpdate.setUrl(image.getUrl());
        else
            imageUpdate = new Image(image.getItemId(), image.getUrl());
        return MapperUtil.toImage(repository.save(MapperUtil.toImageData(imageUpdate)));
    }

    @Override
    public Image findById(Integer id) {
        try {
            return MapperUtil.toImage(repository.findById(id).get());
        } catch(Exception e){
            logger.warn("BD error. Exception whet try to find image By id: "+id);
            return null;
        }
    }
}
