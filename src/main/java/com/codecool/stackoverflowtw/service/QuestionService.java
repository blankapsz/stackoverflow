package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionsDAO questionsDAO;
    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestionsSortedByAnswer() {
        List<Question> sortedByAnswer =  questionsDAO.getAllQuestionsSortedByAnswer();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : sortedByAnswer){
            questionDTOS.add(new QuestionDTO(question.id(), question.title(), question.description(), question.created(), question.answerCount()));
        }
        return questionDTOS;
    }

    public List<QuestionDTO> getAllQuestionsSorted() {
        List<Question> sortedQuestions = questionsDAO.getAllQuestionsSorted();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : sortedQuestions){
            questionDTOS.add(new QuestionDTO(question.id(), question.title(), question.description(), question.created(), question.answerCount()));
        }
        return questionDTOS;
    }

    public List<QuestionDTO> getAllQuestionsSortedByDate() {
        List<Question> sortedByTime = questionsDAO.getAllQuestionsSortedByDate();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : sortedByTime){
            questionDTOS.add(new QuestionDTO(question.id(), question.title(), question.description(), question.created(), question.answerCount()));
        }
        return questionDTOS;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> allQuestions = questionsDAO.getAllQuestions();

        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : allQuestions){
            questionDTOS.add(new QuestionDTO(question.id(), question.title(), question.description(), question.created(), question.answerCount()));
        }
        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {
        return questionsDAO.getQuestionById(id);
    }

    public boolean deleteQuestionById(int id) {
        return questionsDAO.deleteQuestionById(id);
    }

    public void addNewQuestion(NewQuestionDTO question) throws SQLException {
       questionsDAO.addNewQuestion(question);
    }

}
