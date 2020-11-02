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
    skill: [
      { skill_id: 100, skill_name: 'Java' },
      { skill_id: 101, skill_name: 'C++' },
      { skill_id: 102, skill_name: 'PHP' },
    ],
  };

  showDetails: boolean = false;

  toggleDetails(): void {
    this.showDetails = !this.showDetails;
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

  empl: Employee[] = [
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
  ];
}
