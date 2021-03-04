package com.ExampleWebProject.ThymeleafjQueryapp.logic.student;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
	public String currentDateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")
			.format(LocalDateTime.now());

}
