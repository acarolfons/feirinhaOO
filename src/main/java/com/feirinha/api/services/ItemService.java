package com.feirinha.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.ItemRepository;

@Service
public class ItemService {
    final ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Post "/items"
    public Optional<ItemModel> createItem(ItemDTO body) {
        if (itemRepository.existsByName(body.getName())) {
            return Optional.empty();
        }

        ItemModel item = new ItemModel(body);
        itemRepository.save(item);
        return Optional.of(item);
    }

    // Get "/items"
    public List<ItemModel> getAllItems() {
        return itemRepository.findAll();
    }

    // Get "/items/:id"
    public Optional<ItemModel> getItemsById(Long id) {
        return itemRepository.findById(id);
    }

    // Put "/items/:id"
    public Optional<ItemModel> updateItem(Long id, ItemDTO body) {
        Optional<ItemModel> optionalItem = itemRepository.findById(id);
        if (!optionalItem.isPresent()) 
            return Optional.empty();
        
        if (itemRepository.existsByNameAndIdNot(body.getName(), id)) 
            return null; 
        
        ItemModel item = optionalItem.get();
        item.setName(body.getName());
        item.setQuantity(body.getQuantity());
        itemRepository.save(item);

        return Optional.of(item);
    }

    //Delete "/item/:id"
    public boolean deleteItemById(Long id) {
        Optional<ItemModel> item = itemRepository.findById(id);
        if (!item.isPresent()) return false;
        
        itemRepository.deleteById(id);
        return true; 
    }
    

}
