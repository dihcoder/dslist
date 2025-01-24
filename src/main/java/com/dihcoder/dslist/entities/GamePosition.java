package com.dihcoder.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_game_position")
public class GamePosition {

    @EmbeddedId
    private CollectionPK id = new CollectionPK();
    private Integer position;

    public GamePosition(Game game, GameCollection collection, Integer position) {
        this.id.setGame(game);
        this.id.setGameCollection(collection);
        this.position = position;
    }

}
