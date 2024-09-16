package pro.sky.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Mock
    private QuestionRepository questionRepositoryMock;

    //@Mock
    //private Random random;

    private Question question = new Question("test", "test");

    @Test
    void addPositiveTest2() {
        when(questionRepositoryMock.add(any())).thenReturn(question);
        assertEquals(mathQuestionService.add("test", "test"), question);
    }

    @Test
    void addPositiveTest1() {
        when(questionRepositoryMock.add(any())).thenReturn(question);
        assertEquals(mathQuestionService.add(question), question);
    }

    @Test
    void removePositiveTest() {
        when(questionRepositoryMock.remove(any())).thenReturn(question);
        assertEquals(mathQuestionService.remove(question), question);
    }

    @Test
    void removeNegativeTest() {
        when(questionRepositoryMock.remove(any()))
                .thenThrow(QuestionNotFoundException.class);
        org.assertj.core.api.Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> mathQuestionService.remove(question));
    }

    @Test
    void getAllPositiveTest() {
        Collection<Question> testCollection = new ArrayList<>();
        testCollection.add(question);
        testCollection.add(new Question("test1", "test1"));
        when(questionRepositoryMock.getAll()).thenReturn(testCollection);
        assertTrue(mathQuestionService.getAll()
                .containsAll(testCollection));
        org.assertj.core.api.Assertions.assertThat(mathQuestionService.getAll())
                .hasSameSizeAs(testCollection);
        assertEquals(mathQuestionService.getAll(), testCollection);
    }

    @Test
    void getRandomQuestion() {
        Collection<Question> testCollection = new ArrayList<>();
        testCollection.add(question);
        testCollection.add(new Question("test1", "test1"));
        testCollection.add(new Question("test2", "test2"));
        testCollection.add(new Question("test3", "test3"));
        when(questionRepositoryMock.getAll()).thenReturn(testCollection);
        Assertions.assertThat(mathQuestionService.getRandomQuestion())
                .isNotNull();
        Assertions.assertThat(mathQuestionService.getRandomQuestion())
                .isIn(testCollection);
    }
}