package com.second_checkpoint.exercise_one.controller;

import com.second_checkpoint.exercise_one.dto.item.*;
import com.second_checkpoint.exercise_one.dto.kafka.KafkaObject;
import com.second_checkpoint.exercise_one.service.ItemService;
import com.second_checkpoint.exercise_one.producer.ProducerService;
import com.second_checkpoint.exercise_one.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ProducerService producerService;

    @PostMapping("/v1/item/add")
    public ResponseEntity<?> add(@Valid @RequestBody ItemRequest itemRequest) {
        Item item = itemService.add(itemRequest);
        if (item != null) {
            KafkaObject k = new KafkaObject();
            k.setId(item.getId().toString());
            k.setMessage("new");
            producerService.sendMessage(k);
            return new ResponseEntity<>(new ItemApiResponse(item.getId(), "success"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ItemApiResponse(0, "Error"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/v1/item/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(value = "id") Integer id,
                                                          @Valid @RequestBody ItemUpdateRequest itemUpdate) {
        Item item = itemService.updateItem(id, itemUpdate);
        KafkaObject k = new KafkaObject();
        if (item != null ){
            k.setId(item.getId().toString());
            k.setMessage("update");
            producerService.sendMessage(k);
            return new ResponseEntity<>(new ItemApiResponse(item.getId(), "success"), HttpStatus.OK);
        } else {
            k.setMessage("Error");
            producerService.sendMessage(k);
            return new ResponseEntity<>(k, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/v1/item/{id}")
    public ResponseEntity<?> getItem(@PathVariable("id") @Valid Integer id) {
        Item item = itemService.getById(id);
        if (item == null) {
            return new ResponseEntity<>(new ItemApiResponse(null, "Bad Request"), HttpStatus.BAD_REQUEST);
        } else if (item.getId() == null) {
            return new ResponseEntity<>(new ItemApiResponse(null, "Item not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(MapperUtil.toItemResponseDto(item), HttpStatus.OK);
        }
    }
}