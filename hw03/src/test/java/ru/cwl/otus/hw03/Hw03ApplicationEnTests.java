package ru.cwl.otus.hw03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.cwl.otus.hw03.model.QuestionAndAnswer;
import ru.cwl.otus.hw03.service.CsvLoadService;
import ru.cwl.otus.hw03.service.QAService;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest("hw03.locale=EN")
public class Hw03ApplicationEnTests {

    @Autowired
    QAService service;

    @Test
    public void testEN() {
       // CsvLoadService service=new CsvLoadService(Locale.forLanguageTag("EN"));
        List<QuestionAndAnswer> qa = service.getQuestions();
        assertEquals("yes",qa.get(0).getAnswer());
    }

}
