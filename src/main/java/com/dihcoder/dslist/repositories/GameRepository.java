package com.dihcoder.dslist.repositories;

import com.dihcoder.dslist.entities.Game;
import com.dihcoder.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT id, title, game_year AS `year`, img_url AS imgUrl, short_description AS shortDescription, tb_game_position.position
            FROM TB_GAME
            INNER JOIN tb_game_position ON tb_game.id = tb_game_position.game_id
            WHERE tb_game_position.collection_id = :listId
            ORDER BY tb_game_position.position
            """)
    List<GameMinProjection> searchByList(Long listId);
}
