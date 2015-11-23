package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	 User findByLogin(String login);
	  List<User> findFirst10ByIdNotIn(List<Long> users);

}
