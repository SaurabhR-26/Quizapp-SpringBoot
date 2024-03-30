package com.quizapp.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// this is model class i.e. data model class
// snake_casing is in postgresql
// camelCasing in java
@Data // data is annotation // for lombok
@Entity // to use object relational mapping for Question table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // for auto generation, we need to create a sequence in the postgresql and then set the column to it
    private Integer id;
    private String category;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
}
