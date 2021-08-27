package com.second_checkpoint.exercise_two.controller;

import com.second_checkpoint.exercise_two.dto.item.*;
import com.second_checkpoint.exercise_two.service.ItemServiceImpl;
import com.second_checkpoint.exercise_two.util.MapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemServiceImpl service;

    @GetMapping("/vip/item/{id}")
    public ResponseEntity<?> getItem(@PathVariable("id") @Valid Integer id) {
        Item item = service.findById(id);
        if (item != null) {
            return new ResponseEntity<>(MapperUtil.toItemResponseDto(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ItemApiResponse(null, "Item not found"), HttpStatus.NOT_FOUND);
        }
    }
}