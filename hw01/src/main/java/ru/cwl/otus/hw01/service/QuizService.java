package ru.cwl.otus.hw01.service;

import ru.cwl.otus.hw01.data.QuestionAndAnswer;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 23:45.
 */
public class QuizService {
    private InputStream in = System.in;
    private PrintStream out = System.out;
    private QAService loadService;

    public QuizService(QAService loadService) {
        this.loadService = loadService;
    }

    public void start() {

        Scanner user_input = new Scanner(in);
        out.print("введите фамилию:");
        String surname = user_input.next();
        out.print("введите имя:");
        String name = user_input.next();

        int positive = 0;
        int negative = 0;
        for (QuestionAndAnswer qa : loadService.getQuestions()) {
            out.printf("вопрос: %s\n", qa.getQuestion());
            out.print("ответ:");
            String answer = user_input.next();

            if (qa.getAnswer().equals(answer)) {
                positive++;
            } else {
                negative++;
            }
        }

        out.printf("\nстудент: %s %s\n", surname, name);
        out.printf("ответов правильно: %s, неправильно: %s\n", positive, negative);
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }
}
