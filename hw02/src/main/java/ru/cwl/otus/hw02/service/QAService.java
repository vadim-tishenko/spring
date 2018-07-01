package ru.cwl.otus.hw02.service;

import ru.cwl.otus.hw02.model.QuestionAndAnswer;

import java.util.List;

/**
 * Created by vadim.tishenko
 * on 28.06.2018 0:16.
 */
public interface QAService {
    List<QuestionAndAnswer> getQuestions();
}
