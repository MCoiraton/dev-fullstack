import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../interface/User';

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {
  public response:string | undefined;
  static router: any;
  constructor(
      private router: Router,
      private http: HttpClient
  ) {}

  signupMedecin(user:any) {
    return this.http.post<User>('http://localhost:8080/admin/medecin', user)
  }

  signupAdmin(user:any) {
    return this.http.post<User>('http://localhost:8080/superadmin/newadmin', user)
  }
}
