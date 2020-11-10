import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-employeecount',
  templateUrl: './employeecount.component.html',
  styleUrls: ['./employeecount.component.css']
})
export class EmployeecountComponent implements OnInit {
  @Input()
  all:number;
  @Input()
  male:number;
  @Input()
  female:number;

  constructor() { }

  ngOnInit(): void {
  }

}
