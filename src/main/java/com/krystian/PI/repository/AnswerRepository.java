package com.krystian.PI.repository;

import com.krystian.PI.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Krystian on 2016-10-17.
 */
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
