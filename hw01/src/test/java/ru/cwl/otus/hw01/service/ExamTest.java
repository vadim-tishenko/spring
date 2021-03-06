package ru.cwl.otus.hw01.service;

import org.junit.Test;
import ru.cwl.otus.hw01.model.Exam;
import ru.cwl.otus.hw01.model.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 18:15.
 */
public class ExamTest {

    private QuestionAndAnswer qa1=new QuestionAndAnswer("Question1","Answer1");
    private QuestionAndAnswer qa2=new QuestionAndAnswer("Question2","Answer2");
    private Exam exam;

    public ExamTest() {
        List<QuestionAndAnswer> list=new ArrayList<>();
        list.add(qa1);
        list.add(qa2);
        exam = new Exam(list,2);
    }

    @Test
    public void examPassed() {
        exam.checkAnswer(qa1,"Answer1");
        exam.checkAnswer(qa2,"Answer2");
        assertEquals(exam.isPassed(),true);
    }

    @Test
    public void examFailed() {
        exam.checkAnswer(qa1,"Answer1");
        exam.checkAnswer(qa2,"WrongAnswer2");
        assertEquals(exam.isPassed(),false);
    }


}