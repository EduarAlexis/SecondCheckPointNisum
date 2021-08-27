package com.second_checkpoint.exercise_one.repository;

import com.second_checkpoint.exercise_one.entity.CurrencyData;
import com.second_checkpoint.exercise_one.entity.ItemData;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("!test")
public interface ItemRepository extends CrudRepository<ItemData, Integer> {
    List<ItemData> findByCurrency(CurrencyData currency);
}
