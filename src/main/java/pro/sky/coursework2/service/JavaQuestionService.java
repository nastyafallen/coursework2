package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.JavaQuestionRepository;
import pro.sky.coursework2.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository questionRepository;

    private final Random random;

    @Autowired
    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(List.copyOf(questionRepository.getAll()));
        return questionList.get(random.nextInt(questionList.size()));
    }
}
