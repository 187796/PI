package com.krystian.PI.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Krystian on 2016-10-17.
 */
@Entity
public class Answer implements Serializable{

    @GeneratedValue
    @Id
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Question.class, optional = false)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @JsonIgnore
    private Question question;

    public Answer() {}

    public Answer(String name, Question question) {
        this.name = name;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "questionId")
    public void setQuestionId(Long questionId) {
        this.question = new Question();
        this.question.setId(questionId);
    }
}
