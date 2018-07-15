package ru.cwl.otus.hw04;

import org.junit.Test;
import ru.cwl.otus.hw04.model.QuestionAndAnswer;
import ru.cwl.otus.hw04.service.CsvLoadService;
import ru.cwl.otus.hw04.service.LanguageService;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by vadim.tishenko
 * on 08.07.2018 18:58.
 */
public class CsvLoadServiceTest {
    LanguageService languageService;

    @Test
    public void testEN() {
        CsvLoadService service=new CsvLoadService(languageService);
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("yes",qa.get(0).getAnswer());
    }

    @Test
    public void testRU() {
        CsvLoadService service=new CsvLoadService(languageService);
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("да",qa.get(0).getAnswer());
    }
}