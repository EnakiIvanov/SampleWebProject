package com.ExampleWebProject.ThymeleafjQueryapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ExampleWebProject.ThymeleafjQueryapp.logic.user.User;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.user.UserRepository;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.user.UserServiceImpl;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserServiceImpl usi;
	
	
	@RequestMapping("")
	public String editUserProfile(Model model) {
		model.addAttribute("users", userRepo.getAllUsers());
		return "profile";
	}
	
	@RequestMapping(value ="/changeRole", method = {RequestMethod.PUT, RequestMethod.GET})
	public String changeRole(Integer id, String role) {
		userRepo.changeRole(id, role);
		return "redirect:/profile";
	}
	
	@RequestMapping(value ="/disable", method = {RequestMethod.PUT, RequestMethod.GET})
	public String banUnbanUser(Integer id, int enable) {
		userRepo.banUnbanUser(id, enable);
		return "redirect:/profile";
	}
	
	@RequestMapping(value ="/edit", method = {RequestMethod.PUT, RequestMethod.GET})
	public String editUserData(User user) {
		usi.register(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/profile";
	}

	@RequestMapping("/getLoggedUserEmail")
	@ResponseBody
	public String getLoggedUserEmail(String username) {
		return userRepo.getEmailByUsername(username);
	}
	
	@RequestMapping("/getUserId")
	@ResponseBody
	public Integer getUserId(String username) {
		
		return userRepo.getUserIdByUsername(username);
	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public boolean checkUsername(String username, int id) {
		return usi.checkIfUsernameExist(username, id);
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public boolean checkEmail(String email, int id) {
		return usi.checkIfUserExist(email, id);
	}
}
