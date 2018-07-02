package ru.cwl.otus.hw02.ui;

import org.springframework.context.MessageSource;
import ru.cwl.otus.hw02.model.Exam;
import ru.cwl.otus.hw02.model.QuestionAndAnswer;
import ru.cwl.otus.hw02.service.ExamFabricService;

import java.util.Scanner;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 23:45.
 */

public class ExamConsoleUI {
    private ExamFabricService examFabricService;
    MessageSource ms;

    public ExamConsoleUI(ExamFabricService examFabricService,MessageSource ms) {
        this.examFabricService = examFabricService;
        this.ms=ms;

    }

    public void start() {
        Exam exam = examFabricService.getExam();
        start(exam);
    }

    public void start(Exam exam) {

        Scanner user_input = new Scanner(System.in);

        System.out.print("введите фамилию:");
        String surname = user_input.next();
        System.out.print("введите имя:");
        String name = user_input.next();

        for (QuestionAndAnswer qa : exam.getQA()) {
            System.out.printf("вопрос: %s\nответ:", qa.getQuestion());
            String answer = user_input.next();

            exam.checkAnswer(qa, answer);
        }

        System.out.printf("\nстудент: %s %s\n", surname, name);
        if(exam.isPassed()){
            System.out.println("тест пройден\n");
        }else {
            System.out.println("тест провален\n");
        }
    }
}
