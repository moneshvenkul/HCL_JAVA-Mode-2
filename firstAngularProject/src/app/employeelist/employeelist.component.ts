import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css'],
})
export class EmployeelistComponent implements OnInit {
  constructor() { }

  ngOnInit(): void { }

  // empl: Employee[] = [
  //   {
  //     id: 100,
  //     name: 'Ram',
  //     date: '10/12/2020',
  //     gender: 'Male',
  //     salary: 20000,

  //     skill: [
  //       { skill_id: 18, skill_name: 'Java' },
  //       { skill_id: 11, skill_name: 'C++' },
  //     ],
  //   },

  //   {
  //     id: 101,
  //     name: 'Sam',
  //     date: '12/10/2000',
  //     gender: 'Male',
  //     salary: 40000,
  //     skill: [
  //       { skill_id: 12, skill_name: 'J2EE' },
  //       { skill_id: 13, skill_name: 'C' },
  //     ],
  //   },

  //   {
  //     id: 102,
  //     name: 'Penny',
  //     date: '02/08/1988',
  //     gender: 'Female',
  //     salary: 50000,
  //     skill: [
  //       { skill_id: 10, skill_name: 'Java' },
  //       { skill_id: 11, skill_name: 'C++' },
  //     ],
  //   },

  //   {
  //     id: 104,
  //     name: 'Diya',
  //     date: '02/08/1997',
  //     gender: 'Female',
  //     salary: 50000,
  //     skill: [
  //       { skill_id: 19, skill_name: 'Java' },
  //       { skill_id: 11, skill_name: 'C++' },
  //     ],
  //   },

  //   {
  //     id: 105,
  //     name: 'Tina',
  //     date: '02/08/1997',
  //     gender: 'Female',
  //     salary: 50000,
  //     skill: [
  //       { skill_id: 18, skill_name: 'Java' },
  //       { skill_id: 11, skill_name: 'C++' },
  //     ],
  //   },

  //   {
  //     id: 106,
  //     name: 'Monesh',
  //     date: '02/08/1999',
  //     gender: 'Male',
  //     salary: 60000,
  //     skill: [
  //       { skill_id: 18, skill_name: 'Java' },
  //       { skill_id: 11, skill_name: 'C++' },
  //     ],
  //   },
  // ];

  // getTotalEmployeeCount(): number {
  //   return this.empl.length;
  // }

  // getTotalMaleCount(): number {
  //   return this.empl.filter((e) => e.gender === 'Male').length;
  // }

  // getTotalFemaleCount(): number {
  //   return this.empl.filter((e) => e.gender === 'Female').length;
  // }

  // selectedEmployeeCountRadioButton: string="All";
  // onEmployeeCountRadioButtonChange(selectedRadioValue:string):void{
  //   this.selectedEmployeeCountRadioButton=selectedRadioValue;

  // }
}
