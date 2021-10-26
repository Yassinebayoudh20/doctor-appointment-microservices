import { AuthService } from './../../shared/auth.service';
import { UserManagementService } from './../../shared/user-management.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-doctor-management',
  templateUrl: './doctor-management.component.html',
  styleUrls: ['./doctor-management.component.sass']
})
export class DoctorManagementComponent implements OnInit {

  doctorsPatients: any;
  constructor(private userService: UserManagementService, private auth: AuthService) { }

  ngOnInit(): void {
    this.userService.getDoctorAppointement(this.auth.currentUser.id).subscribe((data: any) => {
      this.doctorsPatients = data;
      console.log(this.doctorsPatients);
    });
  }

}
