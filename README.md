# ChatGPT on CLI using Java
![image](https://user-images.githubusercontent.com/49784687/226299272-e594ad57-a3eb-4aa6-9b69-127d1d97a2fb.png)
![image](https://user-images.githubusercontent.com/49784687/226299346-2f58d464-13d4-4624-85db-2bcb664ad85a.png)

# Overview
A simple Java program to chat with ChatGPT from the CLI using the [ChatGPT API Free](https://github.com/ayaka14732/ChatGPTAPIFree) project.

# Requirements
To run the program, the following should be first installed:
* [Java 17 or Higher](https://www.oracle.com/java/technologies/downloads/)
* [Amazon Corretto 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)

# Tools
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download/#section=windows)

# Get an OpenAI API Key
To get an OpenAI API Key, you need to first sign up for an OpenAI account. You can sign up [here](https://platform.openai.com/signup).

Once you have an OpenAI account, you can create an OpenAI API Key [here](https://platform.openai.com/account/api-keys).

# How to Use
1. Install the requirements specified above.
2. Obtain an OpenAI API Key from [here](https://platform.openai.com/account/api-keys).
3. Clone or download this repository.
4. Open this project in IntelliJ IDEA Ultimate.
5. Create a new file called `.env`. Enter the line below in the `.env` file:
```
OPEN_API_KEY = YOUR_API_KEY
```
and replace `YOUR_API_KEY` with your own OpenAI API Key.
6. Run the program.
7. Enter the query when asked, and wait for a reply.
8. You can enter another query, or you can enter `/e` to exit the program.

# Future Implementations
* Implement Picocli

# References
* [ChatGPT API Free](https://github.com/ayaka14732/ChatGPTAPIFree)
* [OpenAI Official Documentation](https://platform.openai.com/docs/api-reference)
