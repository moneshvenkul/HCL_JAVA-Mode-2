import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PasswordValidator } from '../password.validator';
import { ForbiddenNameValidator } from '../username-validator';
 
@Component({
  selector: 'app-reactivedriven',
  templateUrl: './reactivedriven.component.html',
  styleUrls: ['./reactivedriven.component.css']
})
export class ReactivedrivenComponent implements OnInit {
 
  constructor(private fb: FormBuilder,private route:Router) { }
 
  registrationForm: FormGroup;

  get alternateEmails(){
    return this.registrationForm.get('alternateEmails') as FormArray;
  }

  addAlternateEmail(){
    this.alternateEmails.push(this.fb.control(''));
  }

  submitted=false;
  onSubmit(){
    console.log("clicked");
    this.submitted = true;
    if(this.submitted==true){
      this.route.navigate(['/regSuccess']);
    }
  }
 
  ngOnInit(): void {
    this.registrationForm=this.fb.group({
 
      username:['Raj',[Validators.required,Validators.minLength(3),ForbiddenNameValidator]],
      email:[''],
      subscribe:[false],
      password:[''],
      confirmPassword:[''],
      address:this.fb.group({
        city:['chennai'],
        state:['tamilnaidu'],
        postalCode:['76999']
      }),
      alternateEmails:this.fb.array([])
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