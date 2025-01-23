package com.dihcoder.dslist.repositories;

import com.dihcoder.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
