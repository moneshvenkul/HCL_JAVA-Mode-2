package com.pack.SpringBootJPA.service;

import java.util.List;

import com.pack.SpringBootJPA.model.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public List<Student> getStudentsByPage(int pageId, int total);

	public long count();

	public void deleteAllStudent();

	public Student getStudentById(int studentId);

	public void updateStudent(Student st);

	public void deleteStudent(int studentId);
}