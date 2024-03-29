import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup | any;
  constructor(@Inject(LoginService) private LoginService: LoginService) {
    
    this.loginForm = new FormGroup({
      user: new FormControl('', [Validators.required]),
      mdp: new FormControl('', [Validators.required, Validators.pattern(
        '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$')]),
    });
  }

  ngOnInit(): void {
  }

  login() {
    const data = {
      login: this.loginForm.value.user,
      password: this.loginForm.value.mdp,
    }
    if (this.loginForm.valid) {
      this.LoginService.login(data)
    }
    else console.log("erreur")
  }



}
