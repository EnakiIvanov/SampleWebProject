package com.ExampleWebProject.ThymeleafjQueryapp.logic.user;

public interface UserService {
	public void register(User user);
	
	public boolean checkIfUserExist(String email);
	
	public boolean checkIfUsernameExist(String username);
}
