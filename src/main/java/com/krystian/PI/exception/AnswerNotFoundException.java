package com.krystian.PI.exception;

/**
 * Created by Krystian on 2016-10-17.
 */
public class AnswerNotFoundException extends NotFoundException {

    private static final long serialVersionUID = 7647232019736235239L;

    public AnswerNotFoundException(String message) {
        super(message);
    }

    public AnswerNotFoundException(Long answerId) {
        super("Answer with id " + answerId + " was not found");
    }
}
