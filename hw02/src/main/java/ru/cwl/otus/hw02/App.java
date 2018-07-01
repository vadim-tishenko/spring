package ru.cwl.otus.hw02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.cwl.otus.hw02.ui.ExamConsoleUI;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:25.
 */

@ComponentScan
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ExamConsoleUI quiz = ctx.getBean(ExamConsoleUI.class);
        quiz.start();
    }


}
