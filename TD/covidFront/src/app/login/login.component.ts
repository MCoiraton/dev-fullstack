import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login = new FormControl('');
  mdp = new FormControl('');


  constructor(private LoginService: LoginService) {
  }

  ngOnInit(): void {
  }

  submit() {
    const data = {
      login:this.login.value,
      mdp:this.mdp.value,
      role:"test",
    }
    //.subscribe est OBLIGATOIRE car un observable doit l'avoir pour pouvoir être utilisé (j'ai perdu 2h de ma vie)
    this.LoginService.login(data).subscribe(
      response => console.log(response)
    );

  }
}
