package com.ExampleWebProject.ThymeleafjQueryapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ExampleWebProject.ThymeleafjQueryapp.logic.student.Student;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.student.StudentRepository;
import com.ExampleWebProject.ThymeleafjQueryapp.logic.student.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentServiceImpl ssi;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@RequestMapping("/getAll")
	public String Hello(Model model) {		
		model.addAttribute("students", studentRepo.findAll());

		return "students";
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer id) {
		return studentRepo.findById(id);
	}
	
	@PostMapping("/addNew")
	public String addNew(Student student) {
		student.setUpdatedOn(ssi.currentDateTime);
		studentRepo.addNewStudent(student.getName(), student.getDepartment(), 
				student.getUpdatedBy(), student.getUpdatedOn());
		return "redirect:/students/getAll";
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student) {
		student.setUpdatedOn(ssi.currentDateTime);
		studentRepo.save(student);
		return "redirect:/students/getAll";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		studentRepo.deleteById(id);
		return "redirect:/students/getAll";
	}
}
