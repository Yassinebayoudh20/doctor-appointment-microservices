import { IUser } from './../interface/IUser';
import { Observable } from 'rxjs';
import { User } from './../models/user';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelperService } from "@auth0/angular-jwt";
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiUrl = "http://localhost:9002/";
  currentUser: IUser = {
    id: 0,
    username: "",
    email: "",
  }

  constructor(private http: HttpClient) { }

  helper = new JwtHelperService();

  login(username: string, password: string) {
    var reqHeader = new HttpHeaders({ "Content-type": "application/json" })
    return this.http.post(this.apiUrl + "api/auth/signin", { username, password }, { headers: reqHeader }).pipe(
      map((response: any) => {
        const decodedToken = this.helper.decodeToken(response.token);
        this.currentUser.id = decodedToken.user_details["id"];
        this.currentUser.username = decodedToken.user_details["username"];
        this.currentUser.email = decodedToken.user_details["email"];
        return response;
      })
    );
  }

  register(user: User) {
    var reqHeader = new HttpHeaders({ "Content-type": "application/json" });
    return this.http.post(this.apiUrl + "api/auth/signup", user, { headers: reqHeader });
  }

  //example for later use to get access for other methods
  /*
    getUserClaims(){
    this.http.get(this.router, {headers:new HttpHeaders({'Authorization':'Bearer '+localstorage.getItem("user_token")})})
    }
   */
}
