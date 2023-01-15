import { HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-interceptor',
  templateUrl: './interceptor.component.html',
  styleUrls: ['./interceptor.component.css']
})

@Injectable()
export class InterceptorComponent{

  constructor() { 

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = JSON.parse(localStorage.getItem('user')!)?.token;
    console.log(token);
    if (token != null){
      request = request.clone({
        setHeaders:{
          Authorization: 'Basic ' + token
        }
      })
    }

    return next.handle(request);
  }
}
