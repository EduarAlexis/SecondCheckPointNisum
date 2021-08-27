package com.second_checkpoint.exercise_one.dto.item;

import com.second_checkpoint.exercise_one.dto.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ItemResponse
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse   {
    private String sku;
    private String name;
    private Double price;
    private String currency;
    private String thumbnail;
    private List<Image> images;
}