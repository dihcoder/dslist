package com.dihcoder.dslist.services;

import com.dihcoder.dslist.dtos.GameDTO;
import com.dihcoder.dslist.dtos.GameMinDTO;
import com.dihcoder.dslist.entities.Game;
import com.dihcoder.dslist.exceptions.ResourceNotFoundException;
import com.dihcoder.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found"));
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll () {
        List<Game> games = gameRepository.findAll();
        //return games.stream().map(GameMinDTO::new).toList(); // Method Reference
        return games.stream().map(game -> new GameMinDTO(game)).toList(); // Lambda Expression
    }
}
