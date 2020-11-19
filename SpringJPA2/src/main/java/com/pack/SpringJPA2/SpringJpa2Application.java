package com.pack.SpringJPA2;

 

import java.util.ArrayList;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

 

@SpringBootApplication
public class SpringJpa2Application implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repo;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringJpa2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createEmployee();
    	pageSortDemo();
         }
        
    private void pageSortDemo() {
		Iterable<Employee> all = repo.findAll(Sort.by("name"));
		all.forEach(System.out::println);
		
		Pageable pageable = PageRequest.of(0, 2,Sort.by("salary").descending());

		 

        while(true){
            //Page<Employee> page = repo.findAll(pageable);
           Slice<Employee> page = repo.findAll(pageable);
            System.out.println("Page no: "+page.getNumber());
            page.getContent().forEach(System.out::println);
            if(!page.hasNext()){
                break;
            }
            pageable = page.nextPageable();
        }
	}



	private void createEmployee() {
        List<Employee> list=new ArrayList<>();
        Employee e1=new Employee("Diana", "Sales", 2000);
        list.add(e1);
        Employee e2=new Employee("Mike", "Sales", 1000);
        list.add(e2);
        Employee e3=new Employee("Rose", "IT", 4000);
        list.add(e3);
        Employee e4=new Employee("Sara", "Sales", 3000);
        list.add(e4);
        Employee e5=new Employee("Andy", "Sales", 3000);
        list.add(e5);
        Employee e6=new Employee("Charlie", "Sales", 2500);
        list.add(e6);
        Employee e7=new Employee("Jim", "Sales", 4500);
        list.add(e7);
        Employee e8=new Employee("Sam", "Sales", 2500);
        list.add(e8);
        Employee e9=new Employee("Adam", "Sales", 5000);
        list.add(e9);
        Employee e10=new Employee("Tanaka", "Sales", 5500);
        list.add(e10);
        Employee e11=new Employee("Joe", "Sales", 1500);
        list.add(e11);
        repo.saveAll(list);
        
        
    }

 

}