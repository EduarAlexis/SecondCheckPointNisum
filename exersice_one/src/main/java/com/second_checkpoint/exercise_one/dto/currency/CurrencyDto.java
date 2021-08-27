package com.second_checkpoint.exercise_one.dto.currency;

import com.second_checkpoint.exercise_one.dto.item.Item;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private Integer id;
    private String code;
    private String symbol;
    private List<Item> items;
}