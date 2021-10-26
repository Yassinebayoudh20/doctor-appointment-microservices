import { User } from './../models/user';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError, Observable } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  apiUrl = "http://localhost:9002/";

  constructor(private http: HttpClient) { }

  getUsersList(): Observable<any> {
    return this.http.get(this.apiUrl + "api/admin/users", { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem("user_token") }) }).pipe(
      catchError(this.handleError)
    );
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(this.apiUrl + "api/admin/users/" + id, { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem("user_token") }) }).pipe(
      catchError(this.handleError)
    );
  }

  updateUser(id: number, user: User): Observable<any> {
    return this.http.put(this.apiUrl + "api/admin/users/" + id, user, { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem("user_token") }) }).pipe(
      catchError(this.handleError)
    );
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(this.apiUrl + "api/admin/users/" + id, { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem("user_token") }) }).pipe(
      catchError(this.handleError)
    );
  }

  addPatientAppointement(idPatient, idDoctor, appointementDate: Observable<any>) {
    return this.http.post(this.apiUrl + "api/admin/" + idPatient + "/doctors/" + idDoctor + "?appointementDate=" + appointementDate, {}, { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem("user_token") }) }).pipe(
      catchError(this.handleError)
    );
  }

  getDoctorAppointement(idDoctor) {
    return this.http.get("http://localhost:9003/api/appointement/doctor/" + idDoctor).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
