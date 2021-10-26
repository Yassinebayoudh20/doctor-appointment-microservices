import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { AuthService } from '../../shared/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.sass']
})
export class SignupComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl("", Validators.required),
    email: new FormControl("", [Validators.email, Validators.required]),
    password: new FormControl("", Validators.required),
    rpassword: new FormControl("", Validators.required),
    role: new FormControl("", Validators.required)
  });
  get username() { return this.registerForm.get("username") };
  get email() { return this.registerForm.get("email") };
  get password() { return this.registerForm.get("password") };
  get role() { return this.registerForm.get("role") };

  constructor(private userService: AuthService, private route: Router) { }

  ngOnInit(): void {
  }

  registerUser() {
    let user = new User(this.username.value,
      this.email.value,
      this.password.value,
      [this.role.value]);
    this.userService.register(user).subscribe(data => {
      this.route.navigate["/login"];
    });
  }
}


