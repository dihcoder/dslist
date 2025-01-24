package com.dihcoder.dslist.dtos;

import com.dihcoder.dslist.entities.GameCollection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CollectionDTO {
    private Long id;
    private String name;

    public CollectionDTO(GameCollection entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
