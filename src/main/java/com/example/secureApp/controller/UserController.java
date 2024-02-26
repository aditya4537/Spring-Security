package com.example.secureApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.secureApp.entity.User;
import com.example.secureApp.service.UserInterface;

@Controller
public class UserController {
	
	@Autowired
	private UserInterface userInterface;
	
	@GetMapping("/")
	public ModelAndView indexPage(){
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Get the username of the currently logged-in user
        String currentUserName = authentication.getName();
        
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("username", currentUserName);
        
		return mv;
	}

	@GetMapping("/home")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView loginPage(){
		return new ModelAndView("login");
	}
	
	@GetMapping("/logout-success")
	public ModelAndView logoutPage(){
		return new ModelAndView("index");
	}
	
	@GetMapping("/register")
	public ModelAndView registerPage(){
		return new ModelAndView("register");
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		userInterface.addUser(user);
		return new ModelAndView("/login");
	}
	
	
	
	//OAuth
//	@RequestMapping("user")
//	@ResponseBody
//	public Principal user(Principal principal) {
//		return principal;
//	}
	
}
