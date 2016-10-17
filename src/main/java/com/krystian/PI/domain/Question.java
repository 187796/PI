package com.krystian.PI.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Krystian on 2016-10-17.
 */
@Entity
public class Question implements Serializable {


    @GeneratedValue
    @Id
    @Column(name = "question_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "question",targetEntity = Answer.class)
    private List<Answer> answers;

    public Question() {}

    public Question(String name, List<Answer> answers) {
        this.name = name;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
