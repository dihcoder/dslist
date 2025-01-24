package com.dihcoder.dslist.services;

import com.dihcoder.dslist.dtos.CollectionDTO;
import com.dihcoder.dslist.dtos.GameMinDTO;
import com.dihcoder.dslist.entities.Game;
import com.dihcoder.dslist.entities.GameCollection;
import com.dihcoder.dslist.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    @Transactional(readOnly = true)
    public List<CollectionDTO> findAll () {
        List<GameCollection> result = collectionRepository.findAll();
        return result.stream().map(CollectionDTO::new).toList(); // Method Reference
    }
}
