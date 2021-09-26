package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {
}
