package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;

import java.sql.SQLException;
import java.util.List;

public interface AnswerDAO {
    List<Answer> getAnswersByQuestionID(int id);
    int addNewAnswer(Answer answer) throws SQLException;
    boolean deleteAnswer(int id);
}
