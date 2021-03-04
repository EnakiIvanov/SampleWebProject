package com.ExampleWebProject.ThymeleafjQueryapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ExampleWebProject.ThymeleafjQueryapp.logic.user.User;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.user.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public String register(User user) {
		us.register(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public boolean checkEmail(String email) {
		return us.checkIfUserExist(email);
	}

	@RequestMapping("/checkUsername")
	@ResponseBody
	public boolean checkUsername(String username) {
		return us.checkIfUsernameExist(username);
	}
}
