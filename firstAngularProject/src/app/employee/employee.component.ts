import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmployeeComponent implements OnInit {
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

  showDetails1: boolean = false;

  toggleDetails1(): void {
    this.showDetails1 = !this.showDetails1;
  }

  showDetails2: boolean = false;

  toggleDetails2(): void {
    this.showDetails2 = !this.showDetails2;
  }

  showDetails3: boolean = false;

  toggleDetails3(): void {
    this.showDetails3 = !this.showDetails3;
  }

  showDetails4: boolean = false;

  toggleDetails4(): void {
    this.showDetails4 = !this.showDetails4;
  }

  showDetails5: boolean = false;

  toggleDetails5(): void {
    this.showDetails5 = !this.showDetails5;
  }

  jsonVal = { name: "Ram", age: 25, address: "Chennai" };

  months = [
    'jan',
    'feb',
    'mar',
    'apr',
    'may',
    'jun',
    'jul',
    'aug',
    'sept',
    'oct',
    'nov',
    'dec',
  ];

  constructor() {}

  ngOnInit(): void {}

  /* empl: Employee[] = [
    {
      id: 1,
      name: "Monesh",
      date: "07/17/1999",
      gender: "male",
      salary: 1000,
      skill: [{ skill_id: 1, skill_name: 'angular' }],
    },
    {
      id: 2,
      name: "Venkul",
      date: "06/20/1999",
      gender: "male",
      salary: 2000,
      skill: [{ skill_id: 1, skill_name: 'java' }],
    },
    {
      id: 3,
      name: "surya",
      date: "07/20/1999",
      gender: "female",
      salary: 4000,
      skill: [{ skill_id: 1, skill_name: 'c' }],
    },
    {
      id: 4,
      name: "bhava vamsi",
      date: "08/20/1999",
      gender: "female",
      salary: 6000,
      skill: [{ skill_id: 1, skill_name: 'js' }],
    },
  ]; */
}
