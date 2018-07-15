package ru.cwl.otus.hw04.model;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:48.
 */
public class QuestionAndAnswer {
    private String question;
    private String answer;

    public QuestionAndAnswer() {
    }

    public QuestionAndAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
