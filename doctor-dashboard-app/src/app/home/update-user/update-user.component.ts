import { Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserManagementService } from '../../shared/user-management.service';
import { User } from '../../models/user';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.sass']
})
export class UpdateUserComponent implements OnInit {

  user: User;

  updateForm = new FormGroup({
    email: new FormControl(""),
    username: new FormControl("")
  })

  constructor(
    private userManService: UserManagementService,
    private route: ActivatedRoute,
    private navigation: Router) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params.id;
    this.userManService.getUserById(id).subscribe(data => {
      this.user = data
    });
  }

  updateUser() {
    console.log(this.user);
    const id = this.route.snapshot.params.id;
    this.userManService.updateUser(id, this.user).subscribe(data => {
      this.navigation.navigate(["dashboard/user-management"]);
    })
  }

}
