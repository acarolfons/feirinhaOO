package com.feirinha.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.services.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {
    final ItemService itemService;
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ResponseEntity<Object> createItem(@RequestBody @Valid ItemDTO body) { // Nosso @RequestBody é nosso req body e diz que é uma String
        Optional<ItemModel> item = itemService.createItem(body); 
        if(!item.isPresent()) return ResponseEntity.status(HttpStatus.CONFLICT).body("Item já está na lista");   
        return ResponseEntity.status(HttpStatus.CREATED).body(item.get());
    }

    @GetMapping()
    public ResponseEntity<Object> getAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {
        Optional<ItemModel> item = itemService.getItemsById(id);
    
        if (!item.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado!");
        } 
    
        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }
    
}
