package com.second_checkpoint.exercise_one.dto.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

/**
 * ItemRequest
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest   {
    @NotNull(message="Sku required")
    private String sku;

    @NotNull(message="Name required")
    private String name;

    @NotNull(message="Price required")
    private Double price;

    @NotNull(message="Currency required")
    private String currency;

    @NotNull(message="thumbnail required")
    private String thumbnail;
}