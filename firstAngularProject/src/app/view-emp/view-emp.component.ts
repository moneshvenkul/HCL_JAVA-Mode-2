import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  emp: Employee = {
    id: 10,
    name: 'Monesh',
    date: '17/07/1999',
    gender: 'male',
    salary: 90000,
    permanent:true,
    dept:{deptId:1,deptName:'Payroll'},
    skill: [
      { skill_id: 1, skill_name: 'HTML' },
      { skill_id: 2, skill_name: 'CSS' },
      { skill_id: 3, skill_name: 'JAVASCRIPT' },
    ],
    dateOfBirth: new Date('12/31/2000')
  };
  

}
