package com.pack.SpringJPA1;

 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 

@SpringBootApplication
public class SpringJpa1Application implements CommandLineRunner{
    
    @Autowired
    EmployeeRepository repo;

 

    public static void main(String[] args) {
        SpringApplication.run(SpringJpa1Application.class, args);
    }

 

    @Override
    public void run(String... args) throws Exception {
        createEmployee();
        findAllEmployees();
        //checkEmployeeAndDelete(10);
        //updateEmployee(11);
        //derivedQueryInfo();
        //limitedQueryInfo();
        //likeExpressionInfo();
        //countQueryInfo();
        //namedQueryJpa();
    	//queryInfo();
    }

 

    private void queryInfo() {
		List<Employee> list = repo.findByName("%nny");
		list.forEach(System.out::println);
		list = repo.findByName2("nny");
		list.forEach(System.out::println);
		list = repo.findByNameContaining("nny");
		list.forEach(System.out::println);
		
	}



	private void namedQueryJpa() {
        
        System.out.println(" -- finding max salaries in Admin and IT depts  --");
        List<Object[]> list = repo.findMaxSalariesByDept(Arrays.asList("Admin", "HR"));
        list.forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }

 

    private void countQueryInfo() {
        
        System.out.println(" -- finding the employee count in IT dept --");
        long count = repo.countByDept("HR");
        System.out.println(count);

 

 

        System.out.println(" -- finding the employee count with salary greater or equal to 4000  --");
        count = repo.countBySalaryGreaterThanEqual(30000.0);
        System.out.println(count);

 

 

        System.out.println(" -- finding the employee count with name ending with 'e'  --");
        count = repo.countByNameEndingWith("e");
        System.out.println(count);

 

 

        System.out.println(" -- finding the employee count with name like '%a_a' --");
        count = repo.countByNameLike("R%");
        System.out.println(count);
        
    }

 

    private void likeExpressionInfo() {
        System.out.println(" -- finding employee with name like %ana --");
        List<Employee> list = repo.findByNameLike("R%");
        list.forEach(System.out::println);

 

 

        System.out.println(" -- finding employee with dept name more than 3 chars --");
        list = repo.findByDeptLike("___%");
        list.forEach(System.out::println);    
    }

 

    private void limitedQueryInfo() {
        
        System.out.println(" -- finding the employee with max salary --");
        Employee emp = repo.findTopByOrderBySalaryDesc();
        System.out.println(emp);

 

 

        System.out.println(" -- finding the employee with min salary --");
        emp = repo.findTopByOrderBySalaryAsc();
        System.out.println(emp);

 

 

        System.out.println(" -- finding the top 3 employees with max salary --");
        List<Employee> list = repo.findTop3ByOrderBySalaryDesc();
        list.stream().forEach(System.out::println);

 

 

        System.out.println(" -- finding the top 3 employees with min salary --");
        list = repo.findTop3ByOrderBySalaryAsc();
        list.stream().forEach(System.out::println);

 

 

        System.out.println(" -- finding the first 2 employees with salary 30000 --");
        list = repo.findFirst2BySalary(30000.0);
        list.stream().forEach(System.out::println);

 

 

        System.out.println(" -- finding the top 2 employees with max salary in HR dept --");
        list = repo.findFirst2ByDeptOrderBySalaryDesc("HR");
        list.stream().forEach(System.out::println);
    }

 

    private void derivedQueryInfo() {
        
         System.out.println(" -- finding by dept --");
         List<Employee> list = repo.findByDept("HR");
         Iterator<Employee> i=list.iterator();
         while(i.hasNext()) {
             Employee e=(Employee)i.next();
             System.out.println(e);
         }

 

 

         System.out.println(" -- finding by salary greater than 3000 --");
         List<Employee> list2 = repo.findBySalaryGreaterThan(30000.0);
         list2.stream().forEach(System.out::println);

 

 

         System.out.println(" -- finding by dept=HR and salary less than 40000 --");
         List<Employee> list3 = repo.findByDeptAndSalaryLessThan("HR", 40000.0);
         list3.stream().forEach(System.out::println);
    }

 

    private void updateEmployee(int id) {
        if(repo.existsById(id)) {
            System.out.println("-- updating --");
            Employee employee2=repo.findById(id).orElseThrow(RuntimeException::new);
            System.out.println(employee2);
            employee2.setSalary(55000.0);
            repo.save(employee2);
        }
    }

 

    private void checkEmployeeAndDelete(int id) {
        if(repo.existsById(id)) {
            System.out.println("-- find by id --");
            Optional<Employee> employeeOptional =repo.findById(id);
            Employee employee=employeeOptional.orElseThrow(RuntimeException::new);
            System.out.println(employee);
            
            System.out.println("--  deleting --");
            System.out.println(employee);
            repo.delete(employee);
        }
        
    }

 

    private void findAllEmployees() {
        Iterable<Employee> all=repo.findAll();
        System.out.println("All Employees : ");
        all.forEach(item -> System.out.println(item));
        
    }

 

    private void createEmployee() {
        //Employee e1=new Employee(10,"Ram","male","ram@gmail.com",20000.0,"HR");
        //repo.save(e1);
        
        List<Employee> list=new ArrayList<>();
        Employee e2=new Employee(11,"Sam","male","sam@gmail.com",30000.0,"Finance");
        list.add(e2);
        Employee e3=new Employee(12,"Penny","female","penny@gmail.com",35000.0,"Admin");
        list.add(e3);
        Employee e4=new Employee(14,"Rajesh","male","rajesh@gmail.com",40000.0,"HR");
        list.add(e4);
        Employee e5=new Employee(15,"Suchi","female","suchi@gmail.com",45000.0,"Sales");
        list.add(e5);
        repo.saveAll(list);//save multiple employee object
        
    }

 

}
 