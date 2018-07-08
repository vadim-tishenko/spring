package ru.cwl.otus.hw02;

import org.junit.Test;
import ru.cwl.otus.hw02.model.QuestionAndAnswer;
import ru.cwl.otus.hw02.service.CsvLoadService;

import java.util.List;
import java.util.Locale;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

/**
 * Created by vadim.tishenko
 * on 08.07.2018 18:58.
 */
public class CsvLoadServiceTest {

    @Test
    public void testEN() {
        CsvLoadService service=new CsvLoadService(Locale.forLanguageTag("EN"));
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("yes",qa.get(0).getAnswer());
    }

    @Test
    public void testRU() {
        CsvLoadService service=new CsvLoadService(Locale.forLanguageTag("RU"));
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("да",qa.get(0).getAnswer());
    }
}