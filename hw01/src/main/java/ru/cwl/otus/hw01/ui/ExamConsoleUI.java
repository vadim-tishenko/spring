package ru.cwl.otus.hw01.ui;

import ru.cwl.otus.hw01.model.QuestionAndAnswer;
import ru.cwl.otus.hw01.model.Exam;
import ru.cwl.otus.hw01.service.ExamFabricService;

import java.util.Scanner;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 23:45.
 */

public class ExamConsoleUI {
    private final ExamFabricService examFabricService;

    public ExamConsoleUI(ExamFabricService examFabricService) {
        this.examFabricService = examFabricService;
    }

    public void start() {
        Exam exam = examFabricService.getExam();
        start(exam);
    }

    public void start(Exam exam) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("введите фамилию:");
        String surname = userInput.next();
        System.out.print("введите имя:");
        String name = userInput.next();

        for (QuestionAndAnswer qa : exam.getQA()) {
            System.out.printf("вопрос: %s\nответ:", qa.getQuestion());
            String answer = userInput.next();

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
