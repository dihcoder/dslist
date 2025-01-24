package com.dihcoder.dslist.controllers;

import com.dihcoder.dslist.dtos.CollectionDTO;
import com.dihcoder.dslist.dtos.GameInListDTO;
import com.dihcoder.dslist.services.CollectionService;
import com.dihcoder.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/collections")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @Autowired
    GameService gameService;

    @GetMapping
    List<CollectionDTO> findAll() {
        return collectionService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameInListDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
