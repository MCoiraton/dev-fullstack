import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from '../interface/Center';
import { Location } from '@angular/common';
import { FormControl, FormGroup } from '@angular/forms';
import { AppointmentService } from './appointment.service';


@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  centreData: any;
  prenom = new FormControl('');
  nom = new FormControl('');
  mail = new FormControl('');
  date = new FormControl('');
  telephone = new FormControl('');

  constructor(private router: Router, private activatedRoute:ActivatedRoute,
    private AppointmentService : AppointmentService) { 
    console.log(this.router.getCurrentNavigation()?.extras.state) 
  }

  ngOnInit() {
    this.centreData = Object.values(history.state) //Object.values() permet de récupérer notre object state et de le convertir en array 
    console.log(this.centreData)
  }

//Function qu'on appel quand on appuie sur le button pour submit, l'id est auto incrémenté donc on le met à 0 car il ne peut pas être null
  submit() {
    const data = {
      id: 0, 
      appointmentDate: this.date.value, 
      firstName: this.nom.value,
      lastName: this.prenom.value,
      mail: this.mail.value,
      tel: this.telephone.value,
      centre: {
        centre_id: this.centreData[0]
      }
    }
    //.subscribe est OBLIGATOIRE car un observable doit l'avoir pour pouvoir être utilisé (j'ai perdu 2h de ma vie)
    this.AppointmentService.createAppointment(data).subscribe( 
      response => console.log(response)
    );
    
}
}