package ru.cwl.otus.hw03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.cwl.otus.hw03.ui.ExamConsoleUI;

@SpringBootApplication
public class Hw03Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Hw03Application.class, args);
        ExamConsoleUI quiz = ctx.getBean(ExamConsoleUI.class);
        quiz.start();
    }
}
