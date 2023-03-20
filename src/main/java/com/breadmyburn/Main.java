package com.breadmyburn;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.breadmyburn.model.ChatGptMessages;
import com.breadmyburn.model.ChatGptRequest;
import com.breadmyburn.model.ChatGptResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a prompt: ");
        String prompt = scanner.nextLine();

        ObjectMapper objectMapper = new ObjectMapper();
        ChatGptMessages chatGptMessages = new ChatGptMessages("user", prompt);
        String messages = objectMapper.writeValueAsString((chatGptMessages));
        ChatGptRequest chatGptRequest = new ChatGptRequest( "gpt-3.5-turbo", "[" + messages + "]");
        String input = objectMapper.writeValueAsString(chatGptRequest);

        /*
        The output of the string `input` contains several "\" and two quotation marks in the
        message portion of `ChatGptRequest` which makes the input not formatted correctly.

        The process below fixes the input and removes these additional characters.
        */
        String firstFix = input.replace("\\","");
        String secondFix = firstFix.replace("\"[","[");
        String inputFixed = secondFix.replace("]\"","]");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://chatgpt-api.shn.hk/v1/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + dotenv.get("OPENAI_API_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(inputFixed))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200) {
            ChatGptResponse chatGptResponse = objectMapper.readValue(response.body(), ChatGptResponse.class);
            System.out.println(chatGptResponse.getChoices()[0].message().content());

        } else {
            System.out.println(response.statusCode());
            System.out.println(response.body());
        }
    }
}