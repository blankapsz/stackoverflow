package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/sorted/{criteria}")
    public List<QuestionDTO> getAllQuestionsSorted(@PathVariable String criteria) {
        return switch (criteria) {
            case "title" -> questionService.getAllQuestionsSorted();
            case "date" -> questionService.getAllQuestionsSortedByDate();
            case "answerCount" -> questionService.getAllQuestionsSortedByAnswer();
            default -> throw new IllegalArgumentException("No sorting criteria exists.");
        };
    }
    @GetMapping("/all")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDTO getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/add")
    public int addNewQuestion(@RequestBody NewQuestionDTO question) throws SQLException {
        questionService.addNewQuestion(question);
        return 200;
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuestionById(@PathVariable int id) {
        return questionService.deleteQuestionById(id);
    }
}
