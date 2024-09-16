package pro.sky.coursework2.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaQuestionRepositoryTest {

    private final QuestionRepository out = new JavaQuestionRepository();

    private final Question question = new Question("test", "test");

    @Test
    void addPositiveTest() {
        assertThat(out.add(question)).isEqualTo(question);
        assertThat(out.getAll()).contains(question);
    }

    @Test
    void removePositiveTest() {
        out.add(question);
        assertTrue(out.getAll().contains(question));
        out.remove(question);
        assertTrue(out.getAll()
                .isEmpty());
        assertFalse(out.getAll()
                .contains(question));
    }

    @Test
    void removeNegativeTest() {
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(question));
    }

    @Test
    void getAllPositiveTest() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        out.add(question);
        out.add(question1);
        out.add(question2);
        assertThat(out.getAll()).containsExactlyInAnyOrder(question, question1, question2);

    }
}