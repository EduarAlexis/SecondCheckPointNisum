package com.second_checkpoint.exercise_two.util;

import com.second_checkpoint.exercise_two.dto.image.Image;
import com.second_checkpoint.exercise_two.dto.item.Item;
import com.second_checkpoint.exercise_two.dto.item.ItemResponse;
import com.second_checkpoint.exercise_two.entity.ImageData;
import com.second_checkpoint.exercise_two.entity.ItemData;
import org.modelmapper.ModelMapper;

public class MapperUtil {

    private MapperUtil() {
    }

    public static ItemData toItemData(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemData.class);
    }

    public static Item toItem(ItemData itemData) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemData, Item.class);
    }

    public static Item toItem(ItemResponse itemResponse) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemResponse, Item.class);
    }

    public static ItemResponse toItemResponseDto(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemResponse.class);
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