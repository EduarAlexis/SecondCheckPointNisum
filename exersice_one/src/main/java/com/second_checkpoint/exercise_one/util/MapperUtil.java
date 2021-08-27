package com.second_checkpoint.exercise_one.util;

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto;
import com.second_checkpoint.exercise_one.dto.currency.CurrencyResponse;
import com.second_checkpoint.exercise_one.dto.image.Image;
import com.second_checkpoint.exercise_one.dto.item.Item;
import com.second_checkpoint.exercise_one.dto.item.ItemRequest;
import com.second_checkpoint.exercise_one.dto.item.ItemResponse;
import com.second_checkpoint.exercise_one.dto.item.ItemUpdateRequest;
import com.second_checkpoint.exercise_one.entity.CurrencyData;
import com.second_checkpoint.exercise_one.entity.ImageData;
import com.second_checkpoint.exercise_one.entity.ItemData;
import org.modelmapper.ModelMapper;

public class MapperUtil {

    private MapperUtil() {
    }

    public static ItemData toItemData(ItemRequest itemRequestDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemRequestDto, ItemData.class);
    }

    public static ItemData toItemData(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemData.class);
    }

    public static Item toItem(ItemData itemData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemData, Item.class);
    }

    public static Item toItem(ItemRequest itemRequestDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemRequestDto, Item.class);
    }

    public static ItemData toItemData(ItemUpdateRequest itemUpdateRequest) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemUpdateRequest, ItemData.class);
    }
    public static Item toItem(ItemUpdateRequest itemUpdateRequest) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemUpdateRequest, Item.class);
    }

    public static ItemResponse toItemResponseDto(ItemData itemData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemData, ItemResponse.class);
    }

    public static ItemResponse toItemResponseDto(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemResponse.class);
    }

    public static CurrencyResponse toCurrencyResponseDto(CurrencyData currencyData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(currencyData, CurrencyResponse.class);
    }

    public static CurrencyDto toCurrency(CurrencyData currencyData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(currencyData, CurrencyDto.class);
    }

    public static CurrencyData toCurrencyData(CurrencyDto currencyDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(currencyDto, CurrencyData.class);
    }

    public static ImageData toImageData(Image image) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(image, ImageData.class);
    }
    public static Image toImage(ImageData imageData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(imageData, Image.class);
    }
}