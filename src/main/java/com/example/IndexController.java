package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostsService;

@Controller
public class IndexController {
	
	 @Autowired
     private PostsService postsService;
	
	@RequestMapping("/home")
	public String index(Model model) {
        model.addAttribute("posts", postsService.getRecentPosts());
        return "index";
    }
	
	@RequestMapping("/123")
	public String page123(Model model) {
        model.addAttribute("posts", postsService.getRecentPosts());
        return "index";
    }
	
	   @RequestMapping(value = "/post", method = RequestMethod.POST)
	    public String createPost(@RequestParam("text") String postText) {
	        postsService.addPost(new User("Unknown"), postText, new Date()));
	        return "redirect:home";
	    }
	
	
}
