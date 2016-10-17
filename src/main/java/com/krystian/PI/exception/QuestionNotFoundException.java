package com.krystian.PI.exception;


/**
 * Created by Krystian on 2016-10-17.
 */
public class QuestionNotFoundException extends NotFoundException {

    private static final long serialVersionUID = -2807384835920670609L;

    public QuestionNotFoundException(String message) {
        super(message);
    }

    public QuestionNotFoundException(Long questionId) {
        super("Question with id " + questionId + " was not found");
    }
}
