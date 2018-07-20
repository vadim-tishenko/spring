package ru.cwl.otus.hw03.service;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.cwl.otus.hw03.model.QuestionAndAnswer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:30.
 */
public class CsvLoadService implements QAService {

    private final String name;

    public CsvLoadService(Locale locale) {
        name = "/data/questions_" + locale.toLanguageTag() + ".csv";
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
}
