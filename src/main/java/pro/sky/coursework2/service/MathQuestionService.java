package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.MathQuestionRepository;
import pro.sky.coursework2.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{

    private final QuestionRepository questionRepository;

    private final Random random;

    @Autowired
    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
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

    /* This method returns one random question
     * from all math questions */
    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(List.copyOf(questionRepository.getAll()));
        return questionList.get(random.nextInt(questionList.size()));
    }
}
