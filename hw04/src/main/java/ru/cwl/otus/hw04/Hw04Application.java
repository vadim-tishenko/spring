package ru.cwl.otus.hw04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.cwl.otus.hw04.ui.ExamConsoleUI;

@SpringBootApplication
public class Hw04Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw04Application.class, args);
    }
}
