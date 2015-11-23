package com.example.services;

import java.util.*;
import javax.annotation.PostConstruct;
import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

  @Autowired
  private UserRepository usersRepo;
  
  @PostConstruct
  @Transactional
  public void createAdminUser() {
    register("admin", "admin@mail.com", "qwerty");
  }

  public void register(String login, String email, String pass) {
	    String passHash = new BCryptPasswordEncoder().encode(pass);
	    User u = new User(login, email.toLowerCase(), passHash);
	    u.getSubscriptions().add(u); // підпишемо користувача на самого себе
	    usersRepo.save(u);
	  }

  public void subscribe(String login) {
    User currentUser = usersRepo.findOne(1L);
    User u = usersRepo.findByLogin(login);
    currentUser.getSubscriptions().add(u);
  }

  public List<User> getSubscribeRecommendations() {
    User currentUser = usersRepo.findOne(1L);

    List<Long> ignoreIds = new ArrayList<>();
    for(User u : currentUser.getSubscriptions()) {
      ignoreIds.add(u.getId());
    }
    return usersRepo.findFirst10ByIdNotIn(ignoreIds);
  }  
  
  
  
}
