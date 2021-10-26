import { DoctorManagementComponent } from './home/doctor-management/doctor-management.component';
import { PatientAppoitementComponent } from './home/patient-appoitement/patient-appoitement.component';
import { PatientManagementComponent } from './home/patient-management/patient-management.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './user/signin/signin.component';
import { SignupComponent } from './user/signup/signup.component';
import { AuthguardGuard } from './authguard/authguard.guard';
import { UserManagementComponent } from './home/user-management/user-management.component';
import { UpdateUserComponent } from './home/update-user/update-user.component';


export const routes: Routes = [
  {
    path: "dashboard", component: HomeComponent, canActivate: [AuthguardGuard], children: [
      { path: "user-management", component: UserManagementComponent },
      { path: "user-management/updateUser/:id", component: UpdateUserComponent },
      { path: "patient-management", component: PatientManagementComponent },
      { path: "patient-management/appointement/:id", component: PatientAppoitementComponent },
      { path: "doctor-management", component: DoctorManagementComponent }


    ],
  },
  { path: 'register', component: SignupComponent },
  { path: 'login', component: SigninComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
