package com.second_checkpoint.exercise_one.repository;

import com.second_checkpoint.exercise_one.entity.CurrencyData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyData, Integer> {
    CurrencyData findByCode(String currencyCode);
}