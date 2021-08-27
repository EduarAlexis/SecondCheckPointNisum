package com.second_checkpoint.exercise_one.service;

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto;
import com.second_checkpoint.exercise_one.entity.CurrencyData;

public interface CurrencyService {
    CurrencyDto findByCode(String currencyCode);
    CurrencyDto findByCurrencyId(Integer id);
    CurrencyDto updateCurrency(CurrencyData currencyData);
}
