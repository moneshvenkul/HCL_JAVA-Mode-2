package com.pack.SpringBootJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pack.SpringBootJPA.model.Student;

public interface StudentDao extends CrudRepository<Student, Integer> {

	@Query(value = "select * from stud1000 limit :pageid,:total", nativeQuery = true)
	public List<Student> getStudentsByPage(@Param("pageid") int pageid, @Param("total") int total);
}
