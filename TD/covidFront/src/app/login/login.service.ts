import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
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
        return this.http.post<User>(`http://localhost:8080/public/login`, user).subscribe((user) => {
            
        },
        (error) => {
            if (error.status == 200){//error 200 = bon login et mdp
            console.log(error.status);
            localStorage.setItem('user', JSON.stringify(user));
            console.log(localStorage.getItem('user'))
            this.router.navigate(['/search'])
            return user;}
            else {
                console.log("mauvais utilisateur ou mdp")
            }
        })
       
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('user');
        this.router.navigate(['/login']);
    }

    
}