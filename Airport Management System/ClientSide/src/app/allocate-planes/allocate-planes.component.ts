import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hangars } from '../hangars';
import { HangarsService } from '../_services/hangars.service';

@Component({
  selector: 'app-allocate-planes',
  templateUrl: './allocate-planes.component.html',
  styleUrls: ['./allocate-planes.component.css']
})
export class AllocatePlanesComponent implements OnInit {

  hangars: Hangars = new Hangars();

  constructor(private hangarsService: HangarsService, private router: Router) { }

  ngOnInit(): void {
    this.allocatePlane();
  }

  allocatePlane(){
    console.log(this.hangars.planeallocated)
    let id=localStorage.getItem("id");
    this.hangarsService.getHangars(+id)
    .subscribe(data=>{
      this.hangars=data;
    })
  }

  onUpdate(){
    console.log("into update");
    console.log(this.hangars.planeallocated);
    this.hangarsService.updateHangars(this.hangars)
          .subscribe(data => {
     console.log(data);
     this.router.navigate(["manager/viewhangars"]);
    }, error => console.log(error));
        this.hangars = new Hangars();
    }


}
