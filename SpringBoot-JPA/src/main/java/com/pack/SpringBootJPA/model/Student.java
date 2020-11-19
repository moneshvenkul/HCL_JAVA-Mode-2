package com.pack.SpringBootJPA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud1000")
public class Student implements Serializable{
	
	@Id
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private String section;
	private String country;
	private String subjects;
	private String sex;
	private boolean firstAttempt;
	
	private Integer id;
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", section=" + section + ", country=" + country + ", subjects=" + subjects + ", sex="
				+ sex + ", firstAttempt=" + firstAttempt + "]";
	}
	public Student() {
		super();
	}
	public Student(Integer id, String firstName, String lastName, String email, Date dob, String section,
			String country, String subjects, String sex, boolean firstAttempt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.section = section;
		this.country = country;
		this.subjects = subjects;
		this.sex = sex;
		this.firstAttempt = firstAttempt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isFirstAttempt() {
		return firstAttempt;
	}
	public void setFirstAttempt(boolean firstAttempt) {
		this.firstAttempt = firstAttempt;
	}
	
	
	

}
