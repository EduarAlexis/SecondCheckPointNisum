package com.second_checkpoint.exercise_two.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@RedisHash("Item")
public class ItemData implements Serializable {
    private static final long serialVersionUID = 1603714798906422731L;
    private Integer id;
    private String sku;
    private String name;
    private Double price;
    private String description;
    private String thumbnail;
}