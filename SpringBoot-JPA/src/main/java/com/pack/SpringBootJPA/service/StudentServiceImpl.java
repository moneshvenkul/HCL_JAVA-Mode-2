package com.pack.SpringBootJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.SpringBootJPA.dao.StudentDao;
import com.pack.SpringBootJPA.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);

	}

	@Override
	public List<Student> getStudentsByPage(int pageId, int total) {
		List<Student> stuList = studentDao.getStudentsByPage(pageId, total);
		return stuList;
	}

	@Override
	public long count() {
		return studentDao.count();
	}

	@Override
	public void deleteAllStudent() {
		studentDao.deleteAll();

	}

	@Override
	public Student getStudentById(int studentId) {
		
		Optional<Student> optional= studentDao.findById(studentId); 
				Student st=null;
		if (optional.isPresent()) { 
			st=optional.get();
			System.out.println(optional.get());

		} 
		else {
			System.out.printf("No student found with id %d%n", studentId);
		}
		return st;
	}

	@Override
	public void updateStudent(Student st) {
		studentDao.save(st);
		
	}

	@Override
	public void deleteStudent(int studentId) {
		studentDao.deleteById(studentId);
		
	}

}
