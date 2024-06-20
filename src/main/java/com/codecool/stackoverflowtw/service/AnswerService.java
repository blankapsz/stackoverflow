package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public int addNewAnswer(NewAnswerDTO answer) throws SQLException {
        Answer modelAnswer = new Answer(0, answer.message(), LocalDateTime.now(), answer.questionId());
        return answerDAO.addNewAnswer(modelAnswer);
    }

    public List<AnswerDTO> getAnswersByQuestionID(int id) {
        List<Answer> answers = answerDAO.getAnswersByQuestionID(id);
        List<AnswerDTO> answerDTOS = new ArrayList<>();
        for (Answer answer : answers) {
            answerDTOS.add(new AnswerDTO(answer.id(), answer.message(), answer.submission(), answer.questionId()));
        }
        return answerDTOS;
    }

    public boolean deleteAnswerById(int id) {
        return answerDAO.deleteAnswer(id);
    }

}
