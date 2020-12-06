import { Component, OnInit } from '@angular/core';
import { Manager } from '../Manager';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: any;
  manager: Manager = new Manager();

  constructor(private token: TokenStorageService,private userService: UserService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    let id=localStorage.getItem("id");
    this.userService.getUsers(+id)
    .subscribe(data=>{
      this.manager=data;
    })
  }

}
