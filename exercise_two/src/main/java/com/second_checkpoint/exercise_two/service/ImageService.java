package com.second_checkpoint.exercise_two.service;

import com.second_checkpoint.exercise_two.dto.image.Image;

public interface ImageService {
    Image save(Image image);
    Image update(Image image);
    Image findById(Integer id);
}
