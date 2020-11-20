package com.pack.SpringBootJPA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "stud1000")
public class Student implements Serializable {
	@Id
	private Integer id;
	@NotEmpty(message = "{firstName.not.empty}")
	@Size(min = 5, max = 12, message = "{firstName.size}")
	private String firstName;
	@NotEmpty(message = "{lastName.not.empty}")
	private String lastName;

	@NotEmpty(message = "{email.not.empty}")
	@Email(message = "{email.email}")
	private String email;

	@NotNull(message = "{dob.not.empty}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "{dob.past}")
	private Date dob;

	@NotEmpty(message = "{section.not.empty}")
	private String section;

	@NotEmpty(message = "{country.not.empty}")
	private String country;

	@NotEmpty(message = "{subjects.not.empty}")
	private String subjects;

	@NotEmpty(message = "{sex.not.empty}")
	private String sex;
	private boolean firstAttempt;

	public Student() {
		super();

		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", section=" + section + ", country=" + country + ", subjets=" + subjects + ", sex="
				+ sex + ", firstAttempt=" + firstAttempt + "]";
	}

}
