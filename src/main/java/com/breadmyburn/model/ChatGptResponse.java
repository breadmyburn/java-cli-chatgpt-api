package com.breadmyburn.model;

public record ChatGptResponse(
        String id,
        String object,
        int created,
        String model,
        ChatGptResponseUsage usage,
        ChatGptResponseChoice[] choices
) {

    public ChatGptResponseChoice[] getChoices() {
        return this.choices;
    }
}
