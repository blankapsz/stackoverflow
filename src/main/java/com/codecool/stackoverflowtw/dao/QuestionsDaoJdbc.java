package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.DbConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {

    DbConnector dbConnector;

    public QuestionsDaoJdbc(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT id,title, description, created, answer_count from questions";
        return getQuestions(sql);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        String sql = "INSERT INTO questions (title, description, created) VALUES (?, ?, ?)";

        Connection databaseConnection;
        PreparedStatement preparedStatement;

        try {
            databaseConnection = dbConnector.getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);

            preparedStatement.setString(1, question.title());
            preparedStatement.setString(2, question.description());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean deleteQuestionById(int id) {
        String sql = "DELETE FROM questions where id = ?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            pstmt.executeQuery();

            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public QuestionDTO getQuestionById(int id) {
        String sql = "SELECT * FROM questions WHERE id = ?";
        QuestionDTO questionDTO = null;

        try (Connection conn = dbConnector.getConnection();
        PreparedStatement pstmnt = conn.prepareStatement(sql)){

            pstmnt.setInt(1, id);
            ResultSet rs = pstmnt.executeQuery();

            while (rs.next()) {
                int questionId = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDateTime created = rs.getTimestamp("created").toLocalDateTime();
                int answerCount = rs.getInt("answer_count");

                questionDTO = new QuestionDTO(questionId, title, description, created, answerCount);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return questionDTO;
    }

    @Override
    public List<Question> getAllQuestionsSorted() {
        String sql = "SELECT id,title, description, created, answer_count from questions ORDER BY title ASC";
        return getQuestions(sql);
    }

    private List<Question> getQuestions(String sql) {
        List<Question> questions = new ArrayList<>();

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
             ResultSet rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            System.out.println("Columns in the ResultSet:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rsmd.getColumnName(i));
            }

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Timestamp timestamp = rs.getTimestamp("created");
                LocalDateTime created = null;
                if (timestamp != null) {
                    created = timestamp.toLocalDateTime();
                }
                int answerCount = rs.getInt("answer_count");

                Question question = new Question(id, title, description, created, answerCount);
                questions.add(question);
            }
        } catch (Exception e){
            System.out.println("From questionsDAOJdbc: " + e.getMessage());
        }
        return questions;
    }

    @Override
    public List<Question> getAllQuestionsSortedByDate() {
        String sql = "SELECT id,title,created,description, answer_count from questions ORDER BY created DESC";
        return getQuestions(sql);
    }

    @Override
    public List<Question> getAllQuestionsSortedByAnswer() {
        String sql = """
                SELECT q.id, q.title, q.description,q.created, COUNT(a.id) AS answer_count
                FROM questions q
                LEFT JOIN answers a ON q.id = a.question_id
                GROUP BY q.id, q.title, q.description
                ORDER BY answer_count DESC""";
        return getQuestions(sql);
    }

}
