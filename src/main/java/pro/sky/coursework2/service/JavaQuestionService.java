package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions;

    private final Random random;

    public JavaQuestionService() {
        this.random = new Random();
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
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

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(List.copyOf(questions));
        return questionList.get(random.nextInt(questionList.size()));
    }
}
