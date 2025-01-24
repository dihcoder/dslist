package com.dihcoder.dslist.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity // a classe é uma entidade jpa e os seus objetos devem ser persistidos no banco de dados.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_game")
public class Game {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "game_year") // Customizando o nome da coluna no bd
    private Integer year; // "year" é uma palavra reservada do bd
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") // Tipo texto não VARCHAR de 255 caracteres
    private String shortDescription;

    @Column(columnDefinition = "TEXT") // Tipo texto não VARCHAR 255
    private String longDescription;

}
