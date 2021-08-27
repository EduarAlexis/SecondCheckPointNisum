package com.second_checkpoint.exercise_two.dto.image;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @NotNull(message="Required item")
    private int itemId;
    @NotNull(message="Required url")
    private String url;
}
