package com.second_checkpoint.exercise_two.dto.item;

import com.second_checkpoint.exercise_two.dto.image.Image;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer id;
    private String sku;
    private String name;
    private Double price;
    private Integer currencyId;
    private String description;
    private String thumbnail;
    private List<Image> images;
}