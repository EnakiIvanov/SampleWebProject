package com.ExampleWebProject.ThymeleafjQueryapp.logic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public void register(User user){
		String userPass = user.getPassword();
		user.setPassword(encodePassword(userPass));
		user.setRole("ROLE_USER");
		user.setEnabled(1);
		
		userRepo.save(user);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepo.existsByEmail(email) ? false : true;
	}
	
	public boolean checkIfUserExist(String email, int id) {
		return userRepo.existsByEmail(email, id) ? false : true;
	}
	
	@Override
	public boolean checkIfUsernameExist(String username) {
		return userRepo.existsByUsername(username) ? false : true;
	}
	
	public boolean checkIfUsernameExist(String username, int id) {
		return userRepo.existsByUsername(username, id) ? false : true;
	}

	private String encodePassword(String password) {
		return encoder.encode(password);
	}	

}
