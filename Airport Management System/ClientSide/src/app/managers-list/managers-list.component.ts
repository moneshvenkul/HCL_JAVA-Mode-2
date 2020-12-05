import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BoardAdminComponent } from '../board-admin/board-admin.component';
import { Manager } from '../Manager';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-managers-list',
  templateUrl: './managers-list.component.html',
  styleUrls: ['./managers-list.component.css']
})
export class ManagersListComponent implements OnInit {

  @Input() manager: Manager;

  

  constructor(private userService: UserService, private router: Router, private listComponent: BoardAdminComponent) { }

  ngOnInit(): void {
  
  }

  

  editUser(manager: Manager): void{
    console.log("into edit");
    console.log(manager.id);
    localStorage.setItem("id",manager.id.toString());
    this.router.navigate(["edit"]);
  }

  deleteUser() {
    this.userService.deleteUsers(this.manager.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }


}
