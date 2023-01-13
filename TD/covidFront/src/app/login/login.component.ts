import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
        '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$'
      )])
    });
  }

  ngOnInit(): void {
  }

  login() {
    if (this.loginForm.valid) {
      this.LoginService.login(this.loginForm).subscribe(
        response => console.log(response)
      );
    }
    else console.log("erreur")
  }

  signin() {
    const data = {
      login: this.loginForm.value,
      mdp: this.loginForm.value,
      role: "",
    }
    this.LoginService.signin(this.loginForm).subscribe(
      response => console.log(response)
    );

  }

}
