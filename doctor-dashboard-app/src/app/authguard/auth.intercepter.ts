import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent, HttpResponse, HttpUserEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import "rxjs/operator/map";


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router: Router) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {
    if (req.headers.get("No-Auth") == "True")
      return next.handle(req.clone());
    if (localStorage.getItem("user_token") != null)
      var clonedreq = req.clone({
        headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem("user_token"))
      });
    return next.handle(clonedreq);
  }
}
