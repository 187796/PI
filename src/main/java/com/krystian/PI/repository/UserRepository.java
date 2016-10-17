package com.krystian.PI.repository;

import com.krystian.PI.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Krystian on 2016-10-17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findByEmail(String email);
}
