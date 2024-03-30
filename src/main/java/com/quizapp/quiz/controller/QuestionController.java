package com.quizapp.quiz.controller;

import com.quizapp.quiz.model.Question;
import com.quizapp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Basic flow of the backend application
// Controller ==> Service ==> DataAccessObject

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("getQuestion/{qid}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer qid) {
        return questionService.getQuestionById(qid);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        if (questionService.addQuestion(question).equals("Success")) {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failure", HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @DeleteMapping("delete/{qid}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer qid) {
        String response = questionService.deleteQuestion(qid);
        if (response.equals("Success"))
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Specified resource does not exists", HttpStatus.BAD_REQUEST);
    }
}
