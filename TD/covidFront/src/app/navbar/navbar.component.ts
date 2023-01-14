import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  data = "";
  word = '';
  infos = '';
  isLoged=false;
  isAdmin=true;
  constructor(
    private readonly http: HttpClient,
    private readonly router: Router
  ) {
      if(localStorage.getItem('user')!=null) this.isLoged=true
      if(localStorage.getItem('user')?.includes("ADMIN")) this.isAdmin=true
  }

  ngOnInit(): void {
  }
  showData() {
    if (JSON.parse(localStorage.getItem('user')!)) {
      this.data = "Connecté en tant que : " + JSON.parse(localStorage.getItem('user')!).login;
    }
    else {
      this.data = ""
    }

    return this.data;
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
    this.isLoged=false;
    this.isAdmin=false;
    this.router.navigate(['/login']);
  }

  info() {
    let temps: any;
    this.http.get<any>('http://localhost:8080/api/appointment', { observe: 'response' })
      .subscribe({
        next: (resp) => {
          console.log(resp);
          const keys = resp.headers.keys();
          console.log(keys);
          const nbToken = resp.headers.get('X-Rate-Limit-Remaining')
          this.infos = `${nbToken} tokens restant`
        },
        error: (err) => {
          console.error(err);
          const keys = err.headers.keys();
          console.log(keys);
          temps = err.headers.get('x-rate-limit-retry-after-seconds')
          this.infos = `Ressayer après ${temps} secondes`;
          this.router.navigate(['/waiting', temps]);
        }
      });

  }
  
}