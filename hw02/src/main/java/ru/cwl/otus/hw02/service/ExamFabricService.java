package ru.cwl.otus.hw02.service;

import ru.cwl.otus.hw02.model.Exam;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 18:03.
 */
public class ExamFabricService {
    private final QAService loadService;

    public ExamFabricService(QAService loadService) {
        this.loadService = loadService;
    }

    public Exam getExam(){
        Exam exam = new Exam(loadService.getQuestions(), 4);
        return exam;
    }
}
