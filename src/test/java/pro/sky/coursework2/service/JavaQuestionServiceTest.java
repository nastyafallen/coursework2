package pro.sky.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.JavaQuestionRepository;
import pro.sky.coursework2.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private JavaQuestionRepository repositoryMock;

    private final Question question = new Question("test", "test");

    @Test
    public void addPositiveTest1() {
        when(repositoryMock.add(question)).thenReturn(question);
        assertEquals(out.add(question), question);
    }

    @Test
    public void addPositiveTest2() {
        when(repositoryMock.add(any())).thenReturn(question);
        assertEquals(out.add(new Question("test", "test")), question);
    }

    @Test
    public void removePositiveTest() {
        when(repositoryMock.remove(any())).thenReturn(question);
        assertEquals(out.remove(question), question);
    }

    @Test
    public void removeNegativeTest() {
        when(repositoryMock.remove(any())).thenThrow(QuestionNotFoundException.class);
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(question));
    }

    @Test
    public void getAllPositiveTest() {
        Question question1 = new Question("test1", "test1");
        List<Question> testList = new ArrayList<>(List.of(question, question1));
        when(repositoryMock.getAll()).thenReturn(testList);
        assertTrue(out.getAll()
                .containsAll(testList));
        Assertions.assertThat(out.getAll())
                .hasSameSizeAs(testList);
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(question, question1);
    }

    @Test
    public void getRandomQuestion() {
        Question question1 = new Question("test1", "test1");
        List<Question> testList = new ArrayList<>(List.of(question, question1));
        when(repositoryMock.getAll()).thenReturn(testList);
        Assertions.assertThat(out.getRandomQuestion())
                .isIn(testList);
    }
}