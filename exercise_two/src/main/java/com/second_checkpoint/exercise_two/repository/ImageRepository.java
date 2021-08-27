package com.second_checkpoint.exercise_two.repository;

import com.second_checkpoint.exercise_two.entity.ImageData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageData, Integer> {
}
