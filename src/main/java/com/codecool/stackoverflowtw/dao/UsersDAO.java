package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.dao.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    List<User> getAllUser();
    User getUserById(int id);
    void addNewUser(NewUserDTO user) throws SQLException;
    boolean updateUserById(int id, String username, String password);
    boolean deleteUserById(int id);
    boolean authenticateUser(NewUserDTO user);
}
