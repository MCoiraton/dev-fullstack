import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from '../interface/Center';
import { Location } from '@angular/common';
import { FormControl, FormGroup } from '@angular/forms';
import { AppointmentService } from './appointment.service';
import { HttpClient } from '@angular/common/http';
import { Appointment } from '../interface/Appointment';



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
  word = '';
  infos = '';
  httpClient: any;
  private urlPost = 'http://localhost:8080/api/appointment'

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
    private AppointmentService: AppointmentService,
    private readonly http: HttpClient) {
    console.log(this.router.getCurrentNavigation()?.extras.state);
    
  }

  ngOnInit() {
    if (Object.values(history.state)[0]!= 1) {
      localStorage.setItem("centreData", Object.values(history.state).join(":"))//on garde le centre en local pour ne pas le perdre après refresh de la page
      this.centreData = Object.values(history.state) //Object.values() permet de récupérer notre object state et de le convertir en array 
      console.log(this.centreData)
      console.log(localStorage.getItem("centreData"))
    }
    else {
      this.centreData= localStorage.getItem("centreData")?.split(":")
    }
  }
  //Fonction qu'on appel quand on appuie sur le button pour submit, l'id est auto incrémenté donc on le met à 0 car il ne peut pas être null
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

    //Utilisation de l'exemple vu en cours pour la gestion de la file d'attente après 10 requêtes en 1min. 
    let temps: any;
    this.http.post<any>(this.urlPost, data)
    .subscribe({
      next: (resp) => {
      console.log(resp);
      const keys = resp.headers.keys();
      console.log(Object.keys);
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
    //.subscribe est OBLIGATOIRE car un observable doit l'avoir pour pouvoir être utilisé (j'ai perdu 2h de ma vie)
    



  }
}