package com.second_checkpoint.exercise_one.repository;

import com.second_checkpoint.exercise_one.entity.ImageData;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("!test")
public interface ImageRepository extends CrudRepository<ImageData, Integer> {
}
