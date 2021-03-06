package ru.cwl.otus.hw01.service;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.cwl.otus.hw01.model.QuestionAndAnswer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:30.
 */
public class CsvLoadService implements QAService {

    private String name = "/data/questions.csv";

    public CsvLoadService(){
    }

    @Override
    public List<QuestionAndAnswer> getQuestions() {
        InputStream in = getClass().getResourceAsStream(name);
        InputStreamReader isr = new InputStreamReader(in);
        List<QuestionAndAnswer> beans =
                new CsvToBeanBuilder<QuestionAndAnswer>(isr)
                        .withType(QuestionAndAnswer.class)
                        .build().parse();

        return beans;
    }

    public void setName(String name) {
        this.name = name;
    }
}
