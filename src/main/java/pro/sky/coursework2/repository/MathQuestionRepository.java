package pro.sky.coursework2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    void init() {
        add(new Question("Вопрос по Math 1", "Ответ 1"));
        add(new Question("Вопрос по Math 2", "Ответ 2"));
        add(new Question("Вопрос по Math 3", "Ответ 3"));
        add(new Question("Вопрос по Math 4", "Ответ 4"));
        add(new Question("Вопрос по Math 5", "Ответ 5"));
        add(new Question("Вопрос по Math 6", "Ответ 6"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден!");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions
                .stream()
                .toList();
    }
}
