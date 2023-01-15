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


}

