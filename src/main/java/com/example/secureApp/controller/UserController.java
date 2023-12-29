package com.example.secureApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.UserInfoEndpointConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.secureApp.entity.User;
import com.example.secureApp.service.UserInterface;

@Controller
public class UserController {
	
	@Autowired
	private UserInterface userInterface;
	
	@RequestMapping("/")
	public String indexPage(){
		return "index.jsp";
	}

	@RequestMapping("/home")
	public String home(){
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage(){
		return "logout.jsp";
	}
	
	@RequestMapping("/register")
	public String registerPage(){
		return "register.jsp";
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
