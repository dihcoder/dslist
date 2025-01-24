package com.dihcoder.dslist.services;

import com.dihcoder.dslist.dtos.GameDTO;
import com.dihcoder.dslist.dtos.GameMinDTO;
import com.dihcoder.dslist.entities.Game;
import com.dihcoder.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // injeção de dependência (chamada de uma instânica do GameRepository)

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll () {
        List<Game> games = gameRepository.findAll();
        //return games.stream().map(GameMinDTO::new).toList(); // Method Reference
        return games.stream().map(game -> new GameMinDTO(game)).toList(); // Lambda Expression
    }
}
