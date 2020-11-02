import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  country : any =["India","UK", "China"];

  constructor() { }

  ngOnInit(): void {
  }

  add(value){
    this.country.push(value);
    console.log(this.country);
  }

}
