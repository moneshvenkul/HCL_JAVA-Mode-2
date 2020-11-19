package com.pack.SpringJPA1;

 

import java.util.List;

 

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

 

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
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
    //Count Query
    long countByDept(String deptName);
    long countBySalaryGreaterThanEqual(double salary);
    long countByNameEndingWith(String endString);
    long countByNameLike(String likeString);
    //complex queries
    //@Query("SELECT e.dept, MAX(e.salary) from Employee e GROUP BY e.dept HAVING e.dept in ?1")
    //public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
    //Named Queries
    public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
    
    @Query("SELECT e from Employee e WHERE e.name LIKE ?1")
    public List<Employee> findByName(String name);
    
    @Query("SELECT e from Employee e WHERE e.name LIKE %?1%")
    public List<Employee> findByName2(String name);
    
    public List<Employee> findByNameContaining(String name);
    
    //native queries.
    @Query(value="select * from emp1000 where id=?1", nativeQuery=true)
    public Employee findAllEmployee(Integer id);
    
    //named native query
    List<Employee> findBySalary();
    
    //@param
    @Query("select e from Employee e where e.id = :eid")
    public Employee findEmployee(@Param("eid")Integer empid);
    
    //#entity name
    @Query("SELECT e FROM #{#entityName} e WHERE e.dept=?1")
    public List<Employee> findByDepartment(String deptName);
    
    //@modifying
    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.salary = e.salary+e.salary*:byPercent/100 WHERE e.dept = :dept")
    int updateDeptSalaries(@Param("byPercent") double byPercent,@Param("dept") String dept);
    
    //sort
    public List<Employee> findByDept(String deptName,Sort sort);
}