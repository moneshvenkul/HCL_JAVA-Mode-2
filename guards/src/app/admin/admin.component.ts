import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
 

  constructor(private route:Router, private _authService:AuthService) { 
    
  }


  ngOnInit(): void {
  }

  logout():void
  {
    console.log("logout");
    this._authService.logOut();
    this.route.navigate(['/item']);
  }

}
