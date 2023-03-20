package com.breadmyburn.model;

public record ChatGptResponse(
        String id,
        String object,
        int created,
        String model,
        ChatGptResponseUsage usage,
        ChatGptResponseChoice[] choices
        ) {
}

/*
{
    "id":"chatcmpl-6vpRjGyrGRsupI3YHxA7P0mN51JHu",
    "object":"chat.completion",
    "created":1679240475,
    "model":"gpt-3.5-turbo-0301",
    "usage":{"prompt_tokens":11,"completion_tokens":25,"total_tokens":36},
    "choices":[
        {
            "message":{
                "role":"assistant",
                "content":"\n\nAs an AI language model, I don't have emotions, but I'm functioning well. How can I assist you?"
        },
        "finish_reason":"stop",
        "index":0
        }
    ]
}
*/
