package ru.cwl.otus.hw01.service;

import ru.cwl.otus.hw01.data.QuestionAndAnswer;

import java.util.Scanner;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 23:45.
 */
public class QuizService {
    private DataLoadService loadService;

    public QuizService(DataLoadService loadService) {
        this.loadService = loadService;
    }

    public void start() {

        Scanner user_input = new Scanner(System.in);
        System.out.print("введите фамилию:");
        String surname = user_input.next();
        System.out.print("введите имя:");
        String name = user_input.next();

        int positive = 0;
        int negative = 0;
        for (QuestionAndAnswer qa : loadService.getQuestions()) {
            System.out.printf("вопрос: %s\n", qa.getQuestion());
            System.out.print( "ответ:");
            String answer = user_input.next();

            if (qa.getAnswer().equals(answer)) {
                positive++;
            } else {
                negative++;
            }
        }

        System.out.printf("\nстудент: %s %s\n", surname, name);
        System.out.printf("ответов правильно: %s, неправильно: %s\n", positive, negative);
    }
}
