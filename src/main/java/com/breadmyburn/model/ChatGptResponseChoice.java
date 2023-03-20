package com.breadmyburn.model;

public record ChatGptResponseChoice(
        ChatGptReponseMessage message,
        String finish_reason,
        int index) {
}
