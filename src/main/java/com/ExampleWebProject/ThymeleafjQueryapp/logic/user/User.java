package com.ExampleWebProject.ThymeleafjQueryapp.logic.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

	@Id
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String role;
	private Integer enabled;
}
