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
import org.springframework.data.domain.Sort;

 

@SpringBootApplication
public class SpringJpa1Application implements CommandLineRunner{

 

    @Autowired
    EmployeeRepository repo;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringJpa1Application.class, args);
    }

 

    @Override
    public void run(String... args) throws Exception {
      //  createEmployee();
        //findAllEmployees();
        //checkEmployeeAndDelete(10);
        //updateEmployee(11);
        //derivedQueryInfo();
        //limitedQueryInfo();
        //likeExpressionInfo();
        //countQueryInfo();
        //namedQueryJpa();
        //queryInfo();
        //nativeQueryDemo();
       // paramDemo();
       // modifyingDemo();
        sortDemo();
    }

 

    private void sortDemo() {
        List<Employee> list = repo.findByDept("HR",Sort.by("name","salary").ascending());
        list.forEach(System.out::println);
    }

 

    private void modifyingDemo() {
        int count = repo.updateDeptSalaries(16, "HR");
        System.out.println("updated employees count :- "+count);
        System.out.println("employees details after updating");
        repo.findAll().forEach(System.out::println);
    }

 

    private void paramDemo() {
        Employee emp = repo.findEmployee(15);
        System.out.println(emp);
        List<Employee> list = repo.findByDepartment("Admin");
        list.forEach(System.out::println);
    }

 

    private void nativeQueryDemo() {
        Employee emp = repo.findAllEmployee(15);
        System.out.println(emp);
        List<Employee> list = repo.findBySalary();
        list.forEach(System.out::println);
    }

 

    private void queryInfo() {
        System.out.println("name containing ana");
        List<Employee> list = repo.findByName("%ana");
        list.forEach(System.out::println);
        System.out.println("name containing ana in middle");
        list = repo.findByName2("ana");
        list.forEach(System.out::println);
        System.out.println("name containing ana using containing method");
        list = repo.findByNameContaining("ana");
        list.forEach(System.out::println);
    }

 

    /*private void namedQueryJpa() {
        System.out.println(" -- finding max salaries in Admin and HR depts  --");
        List<Object[]> list = repo.findMaxSalariesByDept(Arrays.asList("Admin", "HR"));
        list.forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }*/

 

    /*private void countQueryInfo() {
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
    }*/

 

    /*private void likeExpressionInfo() {
        System.out.println(" -- finding employee with name like %ana --");
        List<Employee> list = repo.findByNameLike("R%");
        list.forEach(System.out::println);
        
        System.out.println(" -- finding employee with dept name more than 3 chars --");
        list = repo.findByDeptLike("___%");
        list.forEach(System.out::println);
    }*/

 

    /*private void limitedQueryInfo() {
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
*/
    /*private void derivedQueryInfo() {
        System.out.println("__finding by dept__");
        List<Employee> list = repo.findByDept("HR");
        Iterator<Employee> i = list.iterator();
         while(i.hasNext()) {
             Employee e=(Employee)i.next();
             System.out.println(e);
         }
         System.out.println(" -- finding by salary greater than 30000 --");
         List<Employee> list2 = repo.findBySalaryGreaterThan(30000.0);
         list2.stream().forEach(System.out::println);
         System.out.println(" -- finding by dept=HR and salary less than 40000 --");
         List<Employee> list3 = repo.findByDeptAndSalaryLessThan("HR", 40000.0);
         list3.stream().forEach(System.out::println);
    }*/

 

    /*private void updateEmployee(int id) {
        if(repo.existsById(id)) {
            System.out.println("__ updating ___");
            Employee employee = repo.findById(id).orElseThrow(RuntimeException::new);
            System.out.println(employee);
            employee.setSalary(55000.0);
            repo.save(employee);
        }
    }
*/
    /*private void checkEmployeeAndDelete(int id) {
        if(repo.existsById(id)) {
            System.out.println("__ finding by id ___");
            Optional<Employee> employeeOptional = repo.findById(id);
            Employee employee = employeeOptional.orElseThrow(RuntimeException::new);
            System.out.println(employee);
            System.out.println("__deleting__");
            System.out.println(employee);
            repo.delete(employee);
        }
    }*/

 

    /*private void findAllEmployees() {
        Iterable<Employee> all = repo.findAll();
        System.out.println("All employees :-");
        all.forEach(item -> System.out.println(item));
    }*/

 

    private void createEmployee() {
        //To add single employee we use save method.
        //Employee e1 = new Employee(10,"surya","male","surya@gmail.com",30000.0,"HR");
        //repo.save(e1);
        //To save multiple objects we use saveAll method.
        List<Employee> list = new ArrayList<>();
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