package com.krystian.PI.repository;

import com.krystian.PI.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Krystian on 2016-10-17.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Question findByName(String name);
}
