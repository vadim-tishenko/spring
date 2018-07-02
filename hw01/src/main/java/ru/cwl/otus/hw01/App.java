package ru.cwl.otus.hw01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.cwl.otus.hw01.ui.ExamConsoleUI;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:25.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        ExamConsoleUI quiz = ctx.getBean(ExamConsoleUI.class);
        quiz.start();
    }
}
