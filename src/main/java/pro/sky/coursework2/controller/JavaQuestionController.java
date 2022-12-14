package pro.sky.coursework2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestParam String question,
                                                @RequestParam String answer) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(questionService.add(question, answer));
    }

    @GetMapping
    public ResponseEntity<Collection<Question>> getQuestions() {
        return ResponseEntity.ok(questionService.getAll());
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam String question,
                                                   @RequestParam String answer) {
        return ResponseEntity.ok(questionService.remove(new Question(question, answer)));
    }
}
