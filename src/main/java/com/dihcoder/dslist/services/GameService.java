package com.dihcoder.dslist.services;

import com.dihcoder.dslist.dto.GameMinDTO;
import com.dihcoder.dslist.entities.Game;
import com.dihcoder.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // injeção de dependência (chamada de uma instânica do GameRepository)

    public List<GameMinDTO> findAll () {
        List<Game> games = gameRepository.findAll();
        //return games.stream().map(GameMinDTO::new).toList(); // Method Reference
        return games.stream().map(game -> new GameMinDTO(game)).toList(); // Lambda Expression
    }
}
