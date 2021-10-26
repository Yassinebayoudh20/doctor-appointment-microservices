import { AuthService } from './../../shared/auth.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { DatePickerComponent } from 'ng2-date-picker';

import { User } from '../../models/user';
import { UserManagementService } from '../../shared/user-management.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IUser } from '../../interface/IUser';

@Component({
  selector: 'app-patient-appoitement',
  templateUrl: './patient-appoitement.component.html',
  styleUrls: ['./patient-appoitement.component.sass']
})
export class PatientAppoitementComponent implements OnInit {

  user: User;
  currentUser: IUser;
  appDate: any;

  constructor(private userManService: UserManagementService,
    private auth: AuthService,
    private route: ActivatedRoute,
    private navigation: Router) {

  }

  ngOnInit(): void {
    this.currentUser = this.auth.currentUser;
    console.log(this.currentUser)
    const id = this.route.snapshot.params.id;
    this.userManService.getUserById(id).subscribe(data => {
      this.user = data
    });
  }

  changeAppDate(e) {
    this.appDate = e;
  }
  test() {
    this.userManService.addPatientAppointement(this.auth.currentUser.id, this.route.snapshot.params.id, this.appDate).subscribe(data => {
      this.navigation.navigate(['/dashboard/patient-management'])
    });
  }



}
