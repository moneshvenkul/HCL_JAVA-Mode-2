import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-templatedriven',
  templateUrl: './templatedriven.component.html',
  styleUrls: ['./templatedriven.component.css']
})
export class TemplatedrivenComponent implements OnInit {

  topics=['angular','react','vue'];

  userModel=new User("Monesh","monesh@gmail.com",98989898,"default","morning",true);

  constructor(private route:Router) { }

  ngOnInit(): void {
  }
  submitted = false;
  onSubmit() {​​​​​​​
    console.log("clicked");
    this.submitted = true;
    if(this.submitted==true){​​​​​​​
    this.route.navigate(['/regSuccess']);
    }​​​​​​​
  }​​​​​​​

}
