package com.krystian.PI;

import com.krystian.PI.domain.Answer;
import com.krystian.PI.domain.Question;
import com.krystian.PI.domain.User;
import com.krystian.PI.repository.AnswerRepository;
import com.krystian.PI.repository.QuestionRepository;
import com.krystian.PI.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class PiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoUsers(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User("admin", "ap", "a@x.com"));
			userRepository.save(new User("bbb", "bp", "b@x.com"));
			userRepository.save(new User("ccc", "cp", "c@x.com"));
			userRepository.save(new User("ddd", "dp", "d@x.com"));
		};
	}

	@Bean
	public CommandLineRunner demoQuestionsAnswers(QuestionRepository questionRepository, AnswerRepository answerRepository) {
		return (args) -> {
			Question question = questionRepository.save(new Question("Q1",null));
			questionRepository.save(new Question("Q2",null));

			answerRepository.save(new Answer("A1",question));
		};
	}
}
