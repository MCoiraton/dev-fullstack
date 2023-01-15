import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  constructor() { }
  isAuthenticated() {
    if (localStorage.getItem('user') != null) return true
    else return false
  }

  isAuthentificatedAsAdmin() {
    if(JSON.parse(localStorage.getItem('user')!).role.role="ADMIN") return true
    return false;
  }

  isAuthentificatedAsSAdmin(){
    if(JSON.parse(localStorage.getItem('user')!).role.role="SUPERADMIN") return true
    return false;
  }
}

