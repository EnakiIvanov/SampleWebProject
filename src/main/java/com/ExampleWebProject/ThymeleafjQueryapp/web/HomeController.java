package com.ExampleWebProject.ThymeleafjQueryapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ExampleWebProject.ThymeleafjQueryapp.logic.student.Student;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.student.StudentRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@RequestMapping()
	public String home() {
		return "home";
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(int id) {
		return studentRepo.findById(id);
	}

}
