package com.dihcoder.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class CollectionPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private GameCollection gameCollection;

    public CollectionPK(Game game, GameCollection gameCollection) {
        this.game = game;
        this.gameCollection = gameCollection;
    }
}
