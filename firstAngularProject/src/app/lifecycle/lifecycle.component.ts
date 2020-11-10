import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  templateUrl: './lifecycle.component.html',
  styleUrls: ['./lifecycle.component.css'],
})
export class LifecycleComponent {
  data: number = 100;
  constructor() {
    console.log(`new - data is ${this.data}​​​​​ `);
  }
  ngOnInit(): void {
    console.log(`ngOnInit - data is ${this.data}​​​​​ `);
  }
  ngOnChanges() {
    console.log(`ngOnChanges - data is ${this.data}​​​​​ `);
  }
  ngDoCheck() {
    console.log('ngDoCheck');
  }
  ngAfterContentInit() {
    console.log('ngAfterContentInit');
  }
  ngAfterContentChecked() {
    console.log('ngAfterContentChecked');
  }
  ngAfterViewInit() {
    console.log('ngAfterViewInit');
  }
  ngAfterViewChecked() {
    console.log('ngAfterViewChecked');
  }
  ngOnDestroy() {
    console.log('ngOnDestroy');
  }

  addNumber(){
    this.data+=100;
  }

  deleteNumber(){
    this.data-=100;
  }
}
