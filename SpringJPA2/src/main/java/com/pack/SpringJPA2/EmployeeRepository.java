package com.pack.SpringJPA2;     

import org.springframework.data.repository.PagingAndSortingRepository;    


public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {          }