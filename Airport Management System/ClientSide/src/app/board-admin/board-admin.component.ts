import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { Manager } from '../Manager';
import { Router } from '@angular/router';
import { ManagersListComponent } from '../managers-list/managers-list.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {

 
  managers : Observable<Manager[]>;

  content: string;

  togglemanager :boolean=false;

  constructor(private userService: UserService) { }



  reloadData(){
    this.managers = this.userService.getUsersList();
  }


  ngOnInit(): void {
    this.reloadData();
  }

  toggleManager(){
    this.togglemanager=!this.togglemanager;
  }

  deleteUsers() {
    this.userService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }
}
