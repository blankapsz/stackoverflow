package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public record Question(int id, String title, String description, LocalDateTime created, int answerCount) {
}
