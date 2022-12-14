package pro.sky.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.WrongNumberException;
import pro.sky.coursework2.model.Question;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Test
    void getQuestionsPositiveTest() {
        List<Question> testList = new ArrayList<>();
        testList.add(new Question("test1", "test1"));
        testList.add(new Question("test2", "test2"));
        testList.add(new Question("test3", "test3"));
        when(javaQuestionServiceMock.getAll())
                .thenReturn(testList);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(testList.get(1), testList.get(0), testList.get(0), testList.get(2), testList.get(1));
        Assertions.assertThat(out.getQuestions(3)).containsExactlyInAnyOrder(testList.get(0), testList.get(1), testList.get(2));
        Assertions.assertThat(out.getQuestions(1)).containsOnly(testList.get(1));
    }

    @Test
    void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(WrongNumberException.class).isThrownBy(() -> out.getQuestions(-1));
        Assertions.assertThatExceptionOfType(WrongNumberException.class).isThrownBy(() -> out.getQuestions(0));
    }
}