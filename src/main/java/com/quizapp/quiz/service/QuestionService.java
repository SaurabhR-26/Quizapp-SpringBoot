package com.quizapp.quiz.service;

import com.quizapp.quiz.model.Question;
import com.quizapp.quiz.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// ResponseEntity is used to send the response with status code
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public String addQuestion(Question question) {
        try {
            questionDao.save(question);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failure";
    }

    public ResponseEntity<Question> getQuestionById(Integer id) {
        Question que = questionDao.findQuestionById(id);
        if (que != null) {
            return new ResponseEntity<>(que, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public String deleteQuestion(Integer id) {
        Question que = questionDao.findQuestionById(id);
        if (que != null) {
            questionDao.delete(que);
            return "Success";
        } else {
            return "Failure";
        }
    }
}
