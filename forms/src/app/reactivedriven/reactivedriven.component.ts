import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PasswordValidator } from '../password.validator';
 
@Component({
  selector: 'app-reactivedriven',
  templateUrl: './reactivedriven.component.html',
  styleUrls: ['./reactivedriven.component.css']
})
export class ReactivedrivenComponent implements OnInit {
 
  constructor(private fb: FormBuilder) { }
 
  registrationForm: FormGroup;


 
  ngOnInit(): void {
    this.registrationForm=this.fb.group({
 
      username:['Raj',[Validators.required,Validators.minLength(3)]],
      email:[''],
      subscribe:[false],
      password:[''],
      confirmPassword:[''],
      address:this.fb.group({
        city:['chennai'],
        state:['tamilnaidu'],
        postalCode:['76999']
      })
    },{validator:PasswordValidator});
 
    this.registrationForm.get('subscribe').valueChanges
      .subscribe(checkedValue => {
        const email = this.registrationForm.get('email');
        if (checkedValue) {
          email.setValidators(Validators.required);
        } else {
          email.clearValidators();
        }
        email.updateValueAndValidity();
      });
  }
 
  /*registrationForm=new FormGroup({
    username: new FormControl('Sam'),
    password:new FormControl(''),
    confirmPassword:new FormControl(''),
    address:new FormGroup({
      city:new FormControl(''),
      state:new FormControl(''),
      postalCode:new FormControl(''),
    })
  });
  */
  /*loadApiData(){
    this.registrationForm.setValue({
      username:'Ram',
      password:'test',
      confirmPassword:'test',
      address:{
        city:'Chennai',
        state:'Tamilnadu',
        postalCode:532457
      }
    });
  }*/
  
  loadApiData(){
    this.registrationForm.patchValue({
      username:'Ram',
      password:'test',
      confirmPassword:'test'
    });
  }
  get username(){
    return this.registrationForm.get('username');
  }
 
  get email(){
    return this.registrationForm.get('email');
  }
}