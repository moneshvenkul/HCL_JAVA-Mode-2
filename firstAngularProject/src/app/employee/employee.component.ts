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

  showDetails : boolean = false;
  
  toggleDetails():void{
    this.showDetails=!this.showDetails;
  }


  constructor() {}

  ngOnInit(): void {}
}
