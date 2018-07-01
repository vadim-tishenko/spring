package ru.cwl.otus.hw02.model;

import java.util.List;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 16:30.
 */
public class Exam {
    private List<QuestionAndAnswer> questions;
    private int positive = 0;
    private int minPositive;

    public Exam(List<QuestionAndAnswer> questions, int minPositive) {
        this.questions = questions;
        this.minPositive = minPositive;
    }

    public void checkAnswer(QuestionAndAnswer qa, String answer) {
        if (qa.getAnswer().equals(answer)) {
            positive++;
        }
    }

    public List<QuestionAndAnswer> getQA() {
        return questions;
    }

    public boolean isPassed() {
        return positive >= minPositive;
    }
}
