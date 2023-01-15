import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from '../interface/User';

@Injectable({ providedIn: 'root' })
export class LoginService {
    private userSubject: BehaviorSubject<User>;
    public user: Observable<User>;
    public response:string | undefined;
    static router: any;
    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('user')|| '{}'));
        this.user = this.userSubject.asObservable();      
    }

    

    public get userValue(): User {
        return this.userSubject.value;
    }

    login(user:any) {
        let token = window.btoa(user.login + ':' + user.password);
        user.token = window.btoa(user.login + ':' + user.password);
        return this.http.get<User>(`http://localhost:8080/public/user/admin`).subscribe({next: users => {
        users.token = token;
        localStorage.setItem('user', JSON.stringify(users));
        return users;
        }, error: err => {
      return throwError(() => err.error.message || err.statusText);
        }});
    }
       
        
       
    

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('user');
        this.router.navigate(['/login']);
    }

    
}