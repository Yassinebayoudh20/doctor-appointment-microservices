import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserManagementService } from '../../shared/user-management.service';
import { ToastrService } from 'ngx-toastr';
import { User } from '../../models/user';


@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.sass']
})
export class UserManagementComponent implements OnInit {

  constructor(private userManService: UserManagementService, private route: Router, private toastr: ToastrService) { }

  users: User[];

  ngOnInit(): void {
    this.userManService.getUsersList().subscribe(data => {
      this.users = data;
    })
  }

  deleteUser(user: User, id: number) {
    var yes = confirm("Do you really want to delete this user ?");
    if (yes == true) {
      this.userManService.deleteUser(id).subscribe(data => {
        this.toastr.success("deleted", "User " + user.username + " deleted Successfully!")
        let indexOfuser = this.users.indexOf(user);
        this.users.splice(indexOfuser, 1);
      });
    }

  }

}
