package com.second_checkpoint.exercise_one.service;

import com.second_checkpoint.exercise_one.dto.currency.CurrencyDto;
import com.second_checkpoint.exercise_one.dto.item.Item;
import com.second_checkpoint.exercise_one.dto.item.ItemRequest;
import com.second_checkpoint.exercise_one.dto.item.ItemUpdateRequest;
import com.second_checkpoint.exercise_one.entity.ItemData;
import com.second_checkpoint.exercise_one.repository.ItemRepository;
import com.second_checkpoint.exercise_one.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    ImageService imageService;

    @Override
    public Item add(ItemRequest itemRequest) {
        try {
            CurrencyDto currency = currencyService.findByCode(itemRequest.getCurrency());
            if (currency != null) {
                ItemData itemData = MapperUtil.toItemData(itemRequest);
                itemData.setCurrency(MapperUtil.toCurrencyData(currency));
                Item item = MapperUtil.toItem(itemRepository.save(itemData));
                if (item != null) {
                    return item;
                }
            }
        } catch (IllegalArgumentException ex) {
            return null;
        }
        return null;
    }

    @Override
    public Item getById(Integer id) {
        try {
            return MapperUtil.toItem(itemRepository.findById(id).isPresent()?itemRepository.findById(id).get(): new ItemData());
        } catch (NumberFormatException ex) {
            return null;
        } catch (NoSuchElementException ex) {
            return new Item();
        }
    }

    @Override
    public Item updateItem(Integer id, ItemUpdateRequest request) {
        Item updateItem = getById(id);
        CurrencyDto currencyDto = currencyService.findByCode(request.getCurrency());
        updateItem.setCurrencyId(currencyDto != null ? currencyDto.getId() : updateItem.getCurrencyId());
        if (updateItem != null) {
            updateItem.setSku(request.getSku() != null ? request.getSku() : updateItem.getSku());
            updateItem.setThumbnail(request.getThumbnail() != null ? request.getThumbnail() : updateItem.getThumbnail());
            updateItem.setName(request.getName() != null ? request.getName() : updateItem.getName());
            updateItem.setPrice(request.getPrice() != null ? request.getPrice() : updateItem.getPrice());
            updateItem.setDescription(request.getDescription() != null ? request.getDescription() : updateItem.getDescription());
            CurrencyDto currency = currencyService.findByCurrencyId(updateItem.getCurrencyId());
            updateItem.getImages().stream().forEach(im -> imageService.findById(im.getItemId()));
            updateItem.setCurrencyId(currency.getId());
            Item itemReturn = MapperUtil.toItem(itemRepository.save(MapperUtil.toItemData(updateItem)));
            return itemReturn != null ? itemReturn : null;
        }
        return null;
    }
}
