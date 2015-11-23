package com.example.repositories;

import java.util.List;
import java.util.Set;

import com.example.models.Post;
import com.example.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
	public Page<Post> findByAuthorInOrderByCreatedAtDesc(Set<User> users, Pageable pageable);
}
