package ru.cwl.otus.hw04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.cwl.otus.hw04.model.QuestionAndAnswer;
import ru.cwl.otus.hw04.service.CsvLoadService;
import ru.cwl.otus.hw04.service.LanguageService;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * Created by vadim.tishenko
 * on 08.07.2018 18:58.
 */

@RunWith(SpringRunner.class)
public class CsvLoadServiceTest {
    @MockBean
    LanguageService languageService;

    @Test
    public void testEN() {
        given(this.languageService.getLangTag()).willReturn("en");
        CsvLoadService service=new CsvLoadService(languageService);
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("yes",qa.get(0).getAnswer());
    }

    @Test
    public void testRU() {
        given(this.languageService.getLangTag()).willReturn("ru");
        CsvLoadService service=new CsvLoadService(languageService);
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("да",qa.get(0).getAnswer());
    }
}