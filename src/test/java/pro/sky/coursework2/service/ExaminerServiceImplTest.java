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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    private List<Question> testListJava = new ArrayList<>();
    private List<Question> testListMath = new ArrayList<>();
    private List<Question> result;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    /*@Test
    void getQuestionsPositiveTest() {
        doBefore();
        when(javaQuestionServiceMock.getAll())
                .thenReturn(testListJava);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(testListMath);
        assertThat(out.getQuestions(3))
                .isIn(result);
    }

    public void doBefore() {
        testListJava.add(new Question("javaTest1", "test1"));
        testListJava.add(new Question("javaTest2", "test2"));
        testListJava.add(new Question("javaTest3", "test3"));

        testListMath.add(new Question("mathTest1", "test1"));
        testListMath.add(new Question("mathTest2", "test2"));
        testListMath.add(new Question("mathTest3", "test3"));

        result = new ArrayList<>(List.copyOf(testListJava));
        result.addAll(testListMath);
    }*/
    @Test
    void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(WrongNumberException.class).isThrownBy(() -> out.getQuestions(-1));
        Assertions.assertThatExceptionOfType(WrongNumberException.class).isThrownBy(() -> out.getQuestions(0));
    }
}