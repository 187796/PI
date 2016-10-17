package com.krystian.PI.web.rest;

import com.krystian.PI.domain.Question;
import com.krystian.PI.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class QuestionController {
	
	private QuestionService questionService;
	
	@Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestions(Pageable pageable) {
        return ResponseEntity.ok(questionService.getQuestions(pageable));
    }
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestion(@PathVariable(value = "id") Long boardId) {
        return ResponseEntity.ok(questionService.findQuestionById(boardId));
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public ResponseEntity<?> createQuestion(@Valid @RequestBody Question question) throws URISyntaxException {
        return ResponseEntity
            .created(new URI("/questions/" + question.getId()))
            .body(questionService.addQuestion(question));
    }

    @RequestMapping(value = "/questions", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }

}
