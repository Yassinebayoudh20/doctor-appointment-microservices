import { AuthService } from './../../shared/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.sass']
})
export class SigninComponent implements OnInit {
  title = "Login Form";
  isLoginError: boolean = false;
  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  get username() { return this.loginForm.get("username") };
  get password() { return this.loginForm.get("password") };

  constructor(private userService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  loginUser() {
    if (this.loginForm.invalid) return;
    this.userService.login(this.username.value, this.password.value).subscribe((data: any) => {
      console.log(data.token)
      localStorage.setItem("user_token", data.token);
      this.router.navigate(["/dashboard"]);
    }, (error: HttpErrorResponse) => {
      this.isLoginError = true;
    });
  }

}
