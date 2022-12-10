package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.entity.Question;

import java.util.Collection;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    private Set<Question> questions;

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
