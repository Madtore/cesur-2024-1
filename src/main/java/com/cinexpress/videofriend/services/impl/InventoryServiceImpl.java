package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Inventory;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.InventoryRepository;
import com.cinexpress.videofriend.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    MovieServiceImpl movieService;
    @Override
    public void addInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public void updateInventory(Long id, Inventory inventory) {
        Movie movie = movieService.getMovieById(id);
        inventory.getMovies().add(movie);
        inventoryRepository.save(inventory);
    }
    
}
