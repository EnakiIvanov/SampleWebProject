package com.ExampleWebProject.ThymeleafjQueryapp.logic.user;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT count(1) FROM for_testing.users WHERE email = :email")
	boolean existsByEmail(@Param("email") String email);
	
	@Query("SELECT count(1) FROM for_testing.users WHERE username = :username")
	boolean existsByUsername(@Param("username") String username);
	
	@Query("SELECT email FROM for_testing.users WHERE username = :username")
	String getEmailByUsername(@Param("username") String username);
	
	@Query("SELECT id FROM for_testing.users WHERE username = :username")
	Integer getUserIdByUsername(@Param("username") String username);
	
	@Query("SELECT * FROM for_testing.users")
	Iterable<User> getAllUsers();
	
	@Modifying
	@Query("UPDATE for_testing.users SET role = :role WHERE id = :id")
	boolean changeRole(@Param("id") int id, @Param("role") String role);
	
	@Modifying
	@Query("UPDATE for_testing.users SET enabled = :enabled WHERE id = :id")
	boolean banUnbanUser(@Param("id") int id, @Param("enabled") int enabled);
}
