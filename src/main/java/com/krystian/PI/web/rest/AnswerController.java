package com.krystian.PI.web.rest;

import com.krystian.PI.domain.Answer;
import com.krystian.PI.domain.Question;
import com.krystian.PI.service.AnswerService;
import com.krystian.PI.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class AnswerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private AnswerService answerService;

    private QuestionService questionService;

    @Autowired
    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswers(Pageable pageable) {
        return ResponseEntity.ok(answerService.getAnswers(pageable));
    }
	
	@RequestMapping(value = "/answers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswer(@PathVariable(value = "id") Long cardId) {
        return ResponseEntity.ok(answerService.findAnswerById(cardId));
    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@Valid @RequestBody Answer answer) throws URISyntaxException {
        log.info("Creating card with name" + answer.getName());

        Question question = questionService.findQuestionById(answer.getQuestion().getId());
        answer.setQuestion(question);

        return ResponseEntity
            .created(new URI("/answers/" + answer.getId()))
            .body(answerService.addAnswer(answer));
    }

    @RequestMapping(value = "/answers", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnswer(@RequestBody Answer answer) {
        log.info("Updating card with id" + answer.getId());
        return ResponseEntity.ok(answerService.updateAnswer(answer));
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnswer(@PathVariable Long id) {
        log.info("Removing card with id" + id);
        answerService.deleteAnswer(id);
        return ResponseEntity.ok().build();
    }

}
