package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.WrongNumberException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.random = new Random();
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new WrongNumberException("Введены некорректные данные!");
        }
        Set<Question> setOfRandomQuestions = new HashSet<>(amount);
        int questionsFromJava = random.nextInt(amount);
        while (setOfRandomQuestions.size() < questionsFromJava) {
            setOfRandomQuestions.add(javaQuestionService.getRandomQuestion());
        }
        while (setOfRandomQuestions.size() < amount) {
            setOfRandomQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return setOfRandomQuestions;
    }
}
