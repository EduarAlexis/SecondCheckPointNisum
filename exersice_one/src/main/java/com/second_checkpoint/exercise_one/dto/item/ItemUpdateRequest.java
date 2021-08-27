package com.second_checkpoint.exercise_one.dto.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ItemUpdateRequest
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemUpdateRequest {
    private String sku;
    private String name;
    private Double price;
    private String currency;
    private String thumbnail;
    private String description;
}