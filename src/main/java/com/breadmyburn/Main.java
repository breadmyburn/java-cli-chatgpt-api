package com.breadmyburn;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String message = scanner.nextLine();

        String input = """
                {
                  "model": "gpt-3.5-turbo",
                  "messages": [{"role": "user", "content": "%s"}]
                }
                """.formatted(message);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://chatgpt-api.shn.hk/v1/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + dotenv.get("OPEN_API_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}