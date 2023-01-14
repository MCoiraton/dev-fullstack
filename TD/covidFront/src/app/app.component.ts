import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
[x: string]: any;
  title = 'Vaccination Covid';
  
  constructor(
    private readonly http: HttpClient, 
    private readonly router: Router
    ) {

    }
  ngOnInit(): void {
    
  }

data = "";
word = '';
infos = '';



/*hello() {
  this.http.get<any>('http://localhost:8080/hello', {observe: 'response'})
  .subscribe(resp => {
    console.log(resp);
    this.word = resp.body.data;
  });
}*/

showData(){
 if (JSON.parse(localStorage.getItem('user')!)){
  this.data = "Connecté en tant que : " + JSON.parse(localStorage.getItem('user')!).login;
 }
 else{
  this.data = ""
 }

 return this.data;
}

logout() {
  // remove user from local storage to log user out
  localStorage.removeItem('user');
  this.router.navigate(['/login']);
}

info() {
  let temps: any;
  this.http.get<any>('http://localhost:8080/api/appointment', {observe: 'response'})
  .subscribe({
    next: (resp) => {
    console.log(resp);
    const keys = resp.headers.keys();
    console.log(keys);
    const nbToken =  resp.headers.get('X-Rate-Limit-Remaining')
    this.infos = `${nbToken} tokens restant`
  },
  error:  (err) => {
    console.error(err);
    const keys = err.headers.keys();
    console.log(keys);
    temps =  err.headers.get('x-rate-limit-retry-after-seconds')
    this.infos = `Ressayer après ${temps} secondes`;
    this.router.navigate(['/waiting', temps]);
  }
});

}
}

