package com.krystian.PI.service;

import com.krystian.PI.domain.Answer;
import com.krystian.PI.exception.AnswerNotFoundException;
import com.krystian.PI.repository.AnswerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Krystian on 2016-10-17.
 */
@Service
public class AnswerService {

    private final static Logger log = LoggerFactory.getLogger(AnswerService.class);

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    public List<Answer> getAnswers(Pageable pageable) {
        return answerRepository.findAll(pageable).getContent();
    }

    public Answer findAnswerById(Long cardListId) {
        return Optional
                .ofNullable(answerRepository.findOne(cardListId))
                .orElseThrow(() -> new AnswerNotFoundException(cardListId));
    }

    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        return updateAnswer(answer.getId(), answer);
    }

    public Answer updateAnswer(Long id, Answer answer) {
        Answer existingAnswer = findAnswerById(id);

        existingAnswer.setName(answer.getName());

        return answerRepository.save(existingAnswer);
    }

    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }

    public void deleteAnswer(Long id) {
        deleteAnswer(findAnswerById(id));
    }
}
