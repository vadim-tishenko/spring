package ru.cwl.otus.hw04.service;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.cwl.otus.hw04.model.QuestionAndAnswer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by vadim.tishenko
 * on 27.06.2018 21:30.
 */
public class CsvLoadService implements QAService {

    private LanguageService languageService;

    public CsvLoadService(LanguageService languageService) {
        this.languageService = languageService;

    }

    public String getName() {
        return "/data/questions_" + languageService.getLangTag() + ".csv";
    }

    @Override
    public List<QuestionAndAnswer> getQuestions() {
        InputStream in = getClass().getResourceAsStream(getName());
        InputStreamReader isr = new InputStreamReader(in);
        List<QuestionAndAnswer> beans =
                new CsvToBeanBuilder<QuestionAndAnswer>(isr)
                        .withType(QuestionAndAnswer.class)
                        .build().parse();

        return beans;
    }
}
