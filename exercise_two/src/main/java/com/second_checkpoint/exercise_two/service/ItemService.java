package com.second_checkpoint.exercise_two.service;

import com.second_checkpoint.exercise_two.dto.item.Item;

public interface ItemService {
    Item save(Item item);
    Item update(Item item);
    Item findById(Integer id);
}
