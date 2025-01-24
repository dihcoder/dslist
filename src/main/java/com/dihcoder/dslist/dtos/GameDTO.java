package com.dihcoder.dslist.dtos;

import com.dihcoder.dslist.entities.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private String title;
    private Integer year; // "year" é uma palavra reservada do bd
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
