package ru.cwl.otus.hw04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.cwl.otus.hw04.model.QuestionAndAnswer;
import ru.cwl.otus.hw04.service.QAService;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest //("hw04.locale=EN")
public class Hw03ApplicationEnTests {

    @Autowired
    QAService service;

    @Test
    public void testEN() {
       // List<QuestionAndAnswer> qa = service.getQuestions();
       // assertEquals("yes",qa.get(0).getAnswer());
    }

}
