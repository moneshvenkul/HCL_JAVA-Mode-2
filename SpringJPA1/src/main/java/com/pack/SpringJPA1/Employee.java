package com.pack.SpringJPA1;

 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

 

@Entity
@NamedQuery(name="Employee.findMaxSalariesByDept",
query="SELECT e.dept,MAX(e.salary) FROM Employee e GROUP BY e.dept HAVING e.dept in ?1")
@Table(name="emp1")
public class Employee {
    
    @Id
    private Integer id;
    private String name;
    private String gender;
    private String email;
    private Double salary;
    private String dept;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Employee(Integer id, String name, String gender, String email, Double salary, String dept) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", salary="
                + salary + ", dept=" + dept + "]";
    }
    
    

 

}