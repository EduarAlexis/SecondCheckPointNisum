package com.second_checkpoint.exercise_one.dto.currency;

import com.second_checkpoint.exercise_one.dto.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRequest {
    @NotNull(message="Required code")
    private String code;
    @NotNull(message="Required symbol")
    private String symbol;
    @NotNull(message="Required item")
    private List<Item> items;
}