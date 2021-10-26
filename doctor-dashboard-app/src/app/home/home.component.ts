import { IUser } from './../interface/IUser';
import { AuthService } from './../shared/auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }
  currentUser: IUser;
  ngOnInit(): void {
    this.currentUser = this.authService.currentUser;
  }

  logout() {
    localStorage.removeItem("user_token");
    this.router.navigate(["/login"])
  }

}
