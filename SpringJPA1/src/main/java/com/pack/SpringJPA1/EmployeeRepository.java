package com.pack.SpringJPA1;

 

import java.util.List;

 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

 

public interface EmployeeRepository  extends CrudRepository<Employee,Integer>{
    
    //Derived Query
    List<Employee> findByDept(String deptName);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findByDeptAndSalaryLessThan(String deptName, double salary);
    
    //Limited Query
    Employee findTopByOrderBySalaryDesc();
    Employee findTopByOrderBySalaryAsc();
    List<Employee> findTop3ByOrderBySalaryDesc();
    List<Employee> findTop3ByOrderBySalaryAsc();
    List<Employee> findFirst2BySalary(double salary);
    List<Employee> findFirst2ByDeptOrderBySalaryDesc(String deptName);
    
    //Like Expression
    List<Employee> findByNameLike(String likeString);
    List<Employee> findByDeptLike(String likeString);
    
    //count Query
    long countByDept(String deptName);
    long countBySalaryGreaterThanEqual(double salary);
    long countByNameEndingWith(String endString);
    long countByNameLike(String likeString);
    
    //@Query("SELECT e.dept,MAX(e.salary) FROM Employee e GROUP BY e.dept HAVING e.dept in ?1")
    //public List<Object[]> findMaxSalariesByDept(List<String> deptName );
    
    public List<Object[]> findMaxSalariesByDept(List<String> deptName );
    
    @Query("SELECT e FROM Employee e WHERE e.name LIKE ?1")
    public List<Employee> findByName(String name);
    
    @Query("SELECT e FROM Employee e WHERE e.name Like %?1%")
    public List<Employee> findByName2(String name);
    
    public List<Employee> findByNameContaining(String name);
    
    
    
    
    
}
 