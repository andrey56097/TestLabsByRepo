package com.example.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	  @GeneratedValue
	  private Long id;

	  @NotBlank
	  @Size(min = 1, max = 512)
	  @Column(unique = true)
	  private String login;

	  @NotBlank
	  @Size(min = 1, max = 512)
	  @Column(unique = true)
	  private String email;

	  @NotBlank
	  @Size(min = 1, max = 100)
	  private String password;

	  @OneToMany(mappedBy = "author")
	  private List<Post> posts = new ArrayList<>();

	  @ManyToMany
	  private Set<User> subscriptions = new HashSet<>();

	  public User() {}
	  
	public User(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Set<User> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<User> subscriptions) {
		this.subscriptions = subscriptions;
	}

	 // get/set методи
	  
}
