package com.rehnemacollege.backend;

import com.rehnemacollege.backend.model.Company;
import com.rehnemacollege.backend.model.Person;
import com.rehnemacollege.backend.model.Post;
import com.rehnemacollege.backend.model.User;
import com.rehnemacollege.backend.repository.CompanyRepository;
import com.rehnemacollege.backend.repository.PersonRepository;
import com.rehnemacollege.backend.repository.PostRepository;
import com.rehnemacollege.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication implements CommandLineRunner {

	final PostRepository postRepository;
	final PersonRepository personRepository;
	final UserRepository userRepository;
	final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------- run called --------------------");
		Person person = null;
		for (int i = 0; i < 100; i++) {
			person = new Person((long) i, "Ali" + i);
			this.personRepository.save(person);
		}

		Post post = new Post(1L, new Date(), "first post", "we are here", person);
		this.postRepository.save(post);

		Iterable<Post> posts = this.postRepository.findAll();
		for (Post p: posts) {
			System.out.println(p);
		}

		User user = new User(1L, "admin", passwordEncoder.encode("admin"),
				true, "admin", 12, new ArrayList<>());
		userRepository.save(user);

		for (User u: userRepository.findAll()) {
			System.out.println(u);
		}
	}
}
