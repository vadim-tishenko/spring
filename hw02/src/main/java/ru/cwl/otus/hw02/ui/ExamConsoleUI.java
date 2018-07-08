package ru.cwl.otus.hw02.ui;

import org.springframework.context.MessageSource;
import ru.cwl.otus.hw02.model.Exam;
import ru.cwl.otus.hw02.model.QuestionAndAnswer;
import ru.cwl.otus.hw02.service.ExamFabricService;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 23:45.
 */

public class ExamConsoleUI {
    private final ExamFabricService examFabricService;
    private final MessageSource ms;
    private final Locale locale;// = Locale.getDefault();/*Locale.ENGLISH*/

    public ExamConsoleUI(ExamFabricService examFabricService, MessageSource ms, Locale locale) {
        this.examFabricService = examFabricService;
        this.ms = ms;
        this.locale = locale;

    }

    public void start() {
        Exam exam = examFabricService.getExam();
        start(exam);
    }

    public void start(Exam exam) {

        Scanner userInput = new Scanner(System.in);

        System.out.print(tr("ui.surname"));
        String surname = userInput.next();
        System.out.print(tr("ui.name"));
        String name = userInput.next();

        for (QuestionAndAnswer qa : exam.getQA()) {
            System.out.print(tr("ui.qa", qa.getQuestion()));
            String answer = userInput.next();

            exam.checkAnswer(qa, answer);
        }

        System.out.println();
        System.out.println(tr("ui.student", surname, name));
        if (exam.isPassed()) {
            System.out.println(tr("ui.test_ok"));
        } else {
            System.out.println(tr("ui.test_fail"));
        }
        System.out.println();
    }

    private String tr(String key, Object... o) {
        return ms.getMessage(key, o, "key " + key + " don`t translated!", locale);
    }
}
