package com.krystian.PI.service;

import com.krystian.PI.domain.Question;
import com.krystian.PI.exception.QuestionNotFoundException;
import com.krystian.PI.repository.QuestionRepository;
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
public class QuestionService {

    private final static Logger log = LoggerFactory.getLogger(QuestionService.class);

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable).getContent();
    }

    public Question findQuestionById(Long questionId) {
        return Optional
                .ofNullable(questionRepository.findOne(questionId))
                .orElseThrow(() -> new QuestionNotFoundException(questionId));
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        return updateQuestion(question.getId(), question);
    }

    public Question updateQuestion(Long id, Question question) {
        Question existingQuestion = findQuestionById(id);

        existingQuestion.setName(question.getName());

        return questionRepository.save(existingQuestion);
    }

    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public void deleteQuestion(Long id) {
        deleteQuestion(findQuestionById(id));
    }
}
