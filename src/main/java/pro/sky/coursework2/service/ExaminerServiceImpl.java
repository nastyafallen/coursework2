package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.entity.Question;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
