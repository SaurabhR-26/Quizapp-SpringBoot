![Quiz App](QuizApp.jpg)

## Overview

This is a basic Spring Boot application for conducting quizzes. It provides a user-friendly interface for both quiz takers and administrators to manage quizzes, questions, and results.

## Features

- Create, update, delete quizzes
- Add, edit, remove questions within quizzes
- Take quizzes and receive score
- View quiz results 

## Technologies Used

- Java
- Spring Boot
- Postgresql
- Maven

## Getting Started

1. **Clone the repository**

   ```
   git clone https://github.com/SaurabhR-26/Quizapp-SpringBoot
   ```
2. **Setup the Postgresql as follows**
- Create database *questiondb*
- Create 3 tables as *questions*, *quiz* and *quizQuestions*
1. *question*
```
CREATE TABLE IF NOT EXISTS public.question
(
    id integer NOT NULL DEFAULT nextval('question_id_seq'::regclass),
    category character varying COLLATE pg_catalog."default",
    difficulty_level character varying COLLATE pg_catalog."default",
    option1 character varying COLLATE pg_catalog."default",
    option2 character varying COLLATE pg_catalog."default",
    option3 character varying COLLATE pg_catalog."default",
    option4 character varying COLLATE pg_catalog."default",
    question_title character varying COLLATE pg_catalog."default",
    right_answer character varying COLLATE pg_catalog."default",
    CONSTRAINT question_pkey PRIMARY KEY (id)
)
```
2. *quiz*
```
CREATE TABLE IF NOT EXISTS public.quiz
(
    id integer NOT NULL DEFAULT nextval('quiz_seq'::regclass),
    title character varying COLLATE pg_catalog."default",
    CONSTRAINT quiz_pkey PRIMARY KEY (id)
)
```

3. *quizQuestions*
```
CREATE TABLE IF NOT EXISTS public.quiz_questions
(
    quiz_id integer,
    questions_id integer
)
```
4. Create required sequences
5. In project navigate to the properties and set username to `spring.datasource.username = postgres`
6. Also set password for it `spring.datasource.password = password`
7. Check all setups once
8. Run the project 👍

<h1>Happy coding 😀</h1>
