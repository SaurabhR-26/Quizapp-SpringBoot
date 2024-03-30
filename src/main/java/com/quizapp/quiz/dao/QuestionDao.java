package com.quizapp.quiz.dao;

import com.quizapp.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{ // Question ==> model class for data , Integer==> primary key
    List<Question> findByCategory(String category); // customized query
    // here in above method we don't need to write anything related to HQL / JPQL
    // HQL ==> Hibernate Query Language
    // JPQL ==> JPA Query Language

    Question findQuestionById(Integer id);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);


}
