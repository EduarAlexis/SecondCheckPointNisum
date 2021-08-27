package com.second_checkpoint.exercise_two.service;

import com.second_checkpoint.exercise_two.dto.image.Image;
import com.second_checkpoint.exercise_two.dto.item.Item;
import com.second_checkpoint.exercise_two.entity.ItemData;
import com.second_checkpoint.exercise_two.repository.ItemRepository;
import com.second_checkpoint.exercise_two.util.MapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    public ImageService imageService;

    @Autowired
    public ItemRepository repository;

    @Override
    public Item save(Item item) {
        item.getImages().stream().forEach(im -> imageService.save(im));
        return MapperUtil.toItem(repository.save(MapperUtil.toItemData(item)));
    }

    @Override
    public Item update(Item item) {
        item.getImages().stream().forEach(im -> imageService.update(im));
        return MapperUtil.toItem(repository.save(MapperUtil.toItemData(item)));
    }

    @Override
    public Item findById(Integer id) {
        try {
            ItemData item = repository.findById(id).get();
            Item it = MapperUtil.toItem(item);
            it.setCurrencyId(item.getId());
            Image image = imageService.findById(id);
            if (image != null) {
                List<Image> images = new ArrayList<>();
                images.add(image);
                it.setImages(images);
            }
            return it;
        } catch(Exception e){
            logger.warn("BD error. Exception whet try to find iten By id: "+id);
            return null;
        }
    }
}
