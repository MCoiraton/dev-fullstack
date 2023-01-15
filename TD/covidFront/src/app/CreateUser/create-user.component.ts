import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CreateUserService } from './create-user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  loginForm: FormGroup | any;
  roles = [
    {value: 'ADMIN', viewValue: 'ADMIN'},
    {value: 'MEDECIN', viewValue: 'MEDECIN'},
  ];
 
  constructor(@Inject(CreateUserService) private LoginService: CreateUserService) {
    
    this.loginForm = new FormGroup({
      user: new FormControl('', [Validators.required]),
      mdp: new FormControl('', [Validators.required, Validators.pattern(
        '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$')]),
      centreId: new FormControl('', [Validators.required]),
      selectedRole: new FormControl('', [Validators.required])
    });
  }
  ngOnInit(): void {
  }

  signup() {
    const data = {
      login: this.loginForm.value.user,
      password: this.loginForm.value.mdp,
      role: this.loginForm.value.selectedRole,
      centre: {"centre_id": this.loginForm.value.centre_id},
    }
    this.LoginService.signup(data).subscribe(
      response => console.log(response)
    );

  }

}
