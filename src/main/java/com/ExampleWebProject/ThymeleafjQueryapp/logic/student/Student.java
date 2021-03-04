package com.ExampleWebProject.ThymeleafjQueryapp.logic.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("students")
public class Student {
	@Id
	private Integer id;

	private String name;
	
	private String department;

	private String updatedBy;

	private String updatedOn;
}
