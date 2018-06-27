package ru.cwl.otus.hw01.service;

import org.junit.Test;
import ru.cwl.otus.hw01.data.QuestionAndAnswer;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by vadim.tishenko
 * on 28.06.2018 0:15.
 */
public class QuizServiceTest {

    @Test
    public void start() {
        QAService qaService = new QAService() {
            @Override
            public List<QuestionAndAnswer> getQuestions() {
                List<QuestionAndAnswer> result = Collections.singletonList(new QuestionAndAnswer("Q", "A"));
                return result;
            }
        };

        QuizService qs=new QuizService(qaService);
        // на что и как поменять потоки in & out?



    }
}