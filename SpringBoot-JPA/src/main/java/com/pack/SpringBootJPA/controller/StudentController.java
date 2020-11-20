package com.pack.SpringBootJPA.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pack.SpringBootJPA.model.Student;
import com.pack.SpringBootJPA.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
		return sections;
	}

	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}

	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {

		List<String> subjects = new ArrayList<String>();
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("Life Science");
		subjects.add("Political Science");
		subjects.add("Computer Science");
		subjects.add("Mathmatics");
		return subjects;
	}

	@GetMapping(value = "/")
	public String enrollForm(ModelMap model) {
		model.addAttribute("student", new Student());
		return "enroll";
	}

	@PostMapping(value = "/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student st, BindingResult result) {
		String resultForm = "";
		if (result.hasErrors()) {
			resultForm = "enroll";
		} else {
			Random r = new Random();
			int id = r.nextInt(999999) + 100000;
			st.setId(id);
			studentService.saveStudent(st);
			resultForm = "redirect:/viewstudents/1";
		}
		return resultForm;
	}

	@RequestMapping(value = "/viewstudents/{pageid}")
	public ModelAndView view(@PathVariable("pageid") int pageid) {
		int total = 3; // in single page how many rows should have
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		System.out.println(pageid + " " + total);
		int p = pageid - 1;
		List<Student> list = studentService.getStudentsByPage(p, total);

		return new ModelAndView("viewstudents", "list", list);
	}

	@ModelAttribute("pageCount")
	public List<String> initializePageCount() {
		int total = 3;
		List<String> pageCount = new ArrayList<String>();
		long count = studentService.count(); // 9 12
		long result = ((count / total) + (count % total)); // (9/3)+(9%3)=3+0=3 (12/3)+(12%3)=4
		for (int k = 0; k < result; k++) {
			pageCount.add(new Integer(k).toString());
		}

		return pageCount;// 0,1,2 //0,1,2,3
	}
	
	@GetMapping(value="/delete")
	public String deleteAllStudent() {
		studentService.deleteAllStudent();
		return "redirect:/";
	}
	
	@GetMapping(value="/editstudent/{stuid}")
	public String editStudent(@PathVariable("stuid") Integer studentId, ModelMap model ) {
		Student student=studentService.getStudentById(studentId);
		model.addAttribute("editStudent",student);
		return "editStudent";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateStudent (@Valid @ModelAttribute("editstudent")Student student, BindingResult result) {
	String editForm="";
	if(result.hasErrors()) {

	editForm="editStudent";
	}
	else {
	studentService.updateStudent(student);
	editForm="redirect:/viewstudents/1";
	}
	return editForm;
	}
	
	@GetMapping(value="/deletestudent/{stuid}")
	public String deleteStudent(@PathVariable("stuid")Integer sid) {
		studentService.deleteStudent(sid);
		return "redirect:/viewstudents/1";
		
	}
	

}