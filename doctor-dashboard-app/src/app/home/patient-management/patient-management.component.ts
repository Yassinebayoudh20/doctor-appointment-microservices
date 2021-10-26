import { Component, OnInit } from '@angular/core';
import { UserManagementService } from '../../shared/user-management.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-patient-management',
  templateUrl: './patient-management.component.html',
  styleUrls: ['./patient-management.component.sass']
})
export class PatientManagementComponent implements OnInit {

  constructor(private userSerivice: UserManagementService) { }

  doctorsList: User[];

  ngOnInit(): void {
    this.userSerivice.getUsersList().subscribe((data: User[]) => {
      data = data.filter(user => user.roles[0].name == "ROLE_DOCTOR");
      this.doctorsList = data;
    })
  }

}
