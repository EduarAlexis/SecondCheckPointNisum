package com.second_checkpoint.exercise_one.service;

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto;
import com.second_checkpoint.exercise_one.entity.CurrencyData;
import com.second_checkpoint.exercise_one.repository.CurrencyRepository;
import com.second_checkpoint.exercise_one.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl  implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public CurrencyDto findByCode(String currencyCode) {
        return MapperUtil.toCurrency(currencyRepository.findByCode(currencyCode));
    }

    @Override
    public CurrencyDto findByCurrencyId(Integer id) {
        return MapperUtil.toCurrency(currencyRepository.findById(id).get());
    }

    @Override
    public CurrencyDto updateCurrency(CurrencyData currencyData) {
        return MapperUtil.toCurrency(currencyRepository.save(currencyData));
    }
}
