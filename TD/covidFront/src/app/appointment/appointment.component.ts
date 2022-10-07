import { Component, OnInit } from '@angular/core';
import { Center } from '../interface/Center';


@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  constructor() { }

  center: Center = {
    Center_id : 42,
    name: "centre 42",
    adresse : "rue de la reponse",
    ville : "somewherovertherainbow"
  }

  ngOnInit(): void {
  }

}
