package com.second_checkpoint.exercise_one.service;

import com.second_checkpoint.exercise_one.dto.item.Item;
import com.second_checkpoint.exercise_one.dto.item.ItemRequest;
import com.second_checkpoint.exercise_one.dto.item.ItemUpdateRequest;

public interface ItemService {
    Item add(ItemRequest itemRequestDto);
    Item getById(Integer id);
    Item updateItem(Integer id, ItemUpdateRequest item);
}
