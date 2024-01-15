package com.example.gameoftruth2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;

    private String text;

    private Boolean trueOrElse;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Player player;
}
