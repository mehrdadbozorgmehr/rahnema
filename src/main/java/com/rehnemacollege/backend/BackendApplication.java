package com.rehnemacollege.backend;

import com.rehnemacollege.backend.model.Company;
import com.rehnemacollege.backend.model.Person;
import com.rehnemacollege.backend.model.Post;
import com.rehnemacollege.backend.repository.CompanyRepository;
import com.rehnemacollege.backend.repository.PersonRepository;
import com.rehnemacollege.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	final PostRepository postRepository;
	final PersonRepository personRepository;

	@Autowired
	public BackendApplication(PostRepository postRepository, PersonRepository personRepository) {
		this.postRepository = postRepository;
		this.personRepository = personRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------- run called --------------------");
		Person person = new Person("1", "Ali");
		this.personRepository.save(person);


		Post post = new Post(1L, new Date(), "first post", "we are here", person);
		this.postRepository.save(post);

		Iterable<Post> posts = this.postRepository.findAll();
		for (Post p: posts) {
			System.out.println(p);
		}
	}
}
