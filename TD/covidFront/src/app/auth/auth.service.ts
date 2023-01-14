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
    //if(localStorage.getItem('user')!=null) 
    return false;
  }
}

