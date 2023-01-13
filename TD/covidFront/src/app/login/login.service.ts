import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../interface/User';

@Injectable({ providedIn: 'root' })
export class LoginService {
    private userSubject: BehaviorSubject<User>;
    public user: Observable<User>;
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
        console.log(user)
        return this.http.post<any>(`http://localhost:8080/api/login`, {user})
            .pipe(map(user => {
                // store user details and basic auth credentials in local storage to keep user logged in between page refreshes
                user.authdata = window.btoa(user.login + ':' + user.password);
                localStorage.setItem('user', JSON.stringify(user));
                this.userSubject.next(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('user');
        this.router.navigate(['/login']);
    }

    signin(user:any) {
      return this.http.post<User>('http://localhost:8080/api/signin', user)
    }
}