# API automation testing with Java,RestAssured and Cucumber

## Introduction

This project was created to learn and practice Java's Rest Assured Library to test out APIs.

Some of the tools used here are RestAssured, Java, Maven, TestNg, Cucumber.
The tests could be coded either as TestNg tests or BDD Cucumber Gherkin test scenarios.

## Source code

All core and supporting test java classes are located in `src/test` folder. TestNg tests are located in
`com.restassuredtestng` package.

### Cucumber BDD test

Need to have the below libraries for Cucumber - RestAssured Integration and Data modeling and serialization.

#### Maven config

	<dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.3.0</version>
        <scope>compile</scope>
    </dependency>
        <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>5.2.0</version>
    </dependency>
        <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-jvm-deps</artifactId>
        <version>1.0.6</version>
        <scope>provided</scope>
    </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.32</version>
            <scope>provided</scope>
        </dependency>

#### RestAssured with Cucumber and Creating Data Models and POJOs using Lombok Java Lib:

https://qamind.com/blog/how-to-use-lombok-builder-and-data-annotations/
https://qamind.com/blog/bdd-tests-using-rest-assured-and-cucumber/

### json-server custom API

Refer to the code documentation below:

https://github.com/typicode/json-server
https://github.com/typicode/json-server/tree/v0

#### Installation

`npm install json-server`

Create db.json with below content

`{
"posts": [
{ "id": "1", "title": "a title", "views": 100 },
{ "id": "2", "title": "another title", "views": 200 }
],
"comments": [
{ "id": "1", "text": "a comment about post 1", "postId": "1" },
{ "id": "2", "text": "another comment about post 1", "postId": "1" }
],
"profile": {
"name": "typicode"
}
}`

#### Starting the server:

`json-server --watch db.json`

File location: `/RestAssuredPractice/jsonserver_db/db.json`


