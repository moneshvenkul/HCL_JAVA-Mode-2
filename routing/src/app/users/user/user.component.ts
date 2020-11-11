import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user:{id:number, name:string}; 

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.user={
      id:this.route.snapshot.params['id1'],
      name:this.route.snapshot.params['name1']
    };
    this.route.params.subscribe((params:Params) => {
      this.user.id=params['id1'];
      this.user.name=params['name1'];
    }
    );
  }

 

   

}
