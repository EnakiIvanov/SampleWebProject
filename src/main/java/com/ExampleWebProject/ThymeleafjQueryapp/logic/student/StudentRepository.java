package com.ExampleWebProject.ThymeleafjQueryapp.logic.student;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Modifying
	@Query("INSERT INTO for_testing.students (name, department, updated_by, updated_on, role) " + 
			"VALUES (:name, :department, :updatedBy, :updatedOn)")
	boolean addNewStudent(@Param("name") String name, @Param("department") String department,
	@Param("updatedBy") String updatedBy, @Param("updatedOn") String updatedOn);
}
