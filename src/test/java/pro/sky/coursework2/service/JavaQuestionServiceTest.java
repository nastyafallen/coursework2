package pro.sky.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();
    private final Question question = new Question("test", "test");

    @Test
    public void addPositiveTest1() {
        questionService.add("test", "test");
        assertTrue(questionService.getAll().contains(question));
    }

    @Test
    public void addPositiveTest2() {
        questionService.add(question);
        assertTrue(questionService.getAll().contains(question));
    }

    @Test
    public void removePositiveTest() {
        questionService.add(question);
        questionService.remove(question);
        assertTrue(questionService.getAll()
                .isEmpty());
        assertFalse(questionService.getAll()
                .contains(question));
    }

    @Test
    public void removeNegativeTest() {
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(question));
    }

    @Test
    public void getAllPositiveTest() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        List<Question> result = new ArrayList<>(List.of(question1, question2));
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question2);
        questionService.add(question2);
        assertTrue(questionService.getAll()
                .containsAll(result));
        Assertions.assertThat(questionService.getAll())
                .hasSameSizeAs(result);
        assertEquals(questionService.getAll(), result);
    }

    @Test
    public void getRandomQuestion() {
        questionService.add(question);
        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        assertEquals(questionService.getRandomQuestion(), questionList.get(0));
    }

    @Test
    public void getRandomQuestion2() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        questionService.add(question);
        questionService.add(question1);
        questionService.add(question2);
        Assertions.assertThat(questionService.getRandomQuestion())
                .isIn(questionService.getAll());
    }
}