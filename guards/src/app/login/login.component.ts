import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  ngOnInit(): void {
  }
 
  constructor(private _router: Router,private _authService:AuthService) { }
  msg:string;
 
  onSubmit(username:string,password:string){
    if(username=="admin" && password=="password")
    {
    this._authService.login();
    this._router.navigate(['ItemsAdmin']);
    }
    else
    {
      this.msg="Invalid Username and Password"
    }
    
  }
 
 
}