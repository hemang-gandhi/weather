Java Case Study – Weather forecast

# The Task
 Create an API that will retrieve weather metrics of a specific city

# Tools Used

Spring Boot  - 2.1.8.RELEASE

Gradle

Java 8

Lombok

SpringFox Swagger and Swagger UI - 2.7.0

# Supporting libraries

Spring boot validation framework

Devtools

Apache commons lang 3

# Steps to run:

Import into your IDE as existing Gradle project.

or

Download the source code from github and run:

`./gradlew clean build`

2. Go to web browser or postman and execute the below API:

`http://localhost:8080/average?city=ahmedabad`

# Notes:

1. The city parameter is mandatory, without which exception for missing parameter will be thrown.
2. City parameter can be any valid city like Ahmedabad, London, etc.
3. Valid request will generate response like:

```
{
    "dailyAverage": 28.62,    
    "nightlyAverage": 26.44,    
    "pressureAverage": 1006.29
}
 ```

# API Documentation

Swagger can be found `http://localhost:8080/swagger-ui.html` while project is running.

# Reasoning and motivations

1. Used Spring Boot for reduced development time and effort with less/no boilerplate code.
2. Used Java 8 to take advantages of features like Streams, Lambda expressions, fewer lines of code, better date API.
3. Used Swagger to document API. It also provides `try it now` feature to test from the documentation itself.
4. Created Exception Handler to manage all exceptions and provide meaningful messages to user.
5. Used logger at appropriate places and appropriate levels.
6. The code is well structured, documented and segregated as per the design principles and patters. This makes it easy for the developer to extend and maintain.
7. The configurable features like URI to consume and API Key (appID) are in properties file.

