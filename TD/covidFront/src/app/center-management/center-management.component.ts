import { Component, OnInit } from '@angular/core';
import { debounceTime, distinctUntilChanged, Observable, Subject, Subscribable, switchMap, EMPTY } from 'rxjs';
import { Appointment } from '../interface/Appointment';
import { CenterManagementService } from './center-management.service';

@Component({
  selector: 'app-center-management',
  templateUrl: './center-management.component.html',
  styleUrls: ['./center-management.component.css']
})
export class CenterManagementComponent implements OnInit {
  appointments: Appointment[] = [];
  appointments$: Observable<Appointment[]>=EMPTY;
  centreData: any;

  constructor(private CenterManagementService: CenterManagementService) {

  }

  ngOnInit(): void {
    if (Object.values(history.state)[0] != 1) {
      localStorage.setItem("centreData", Object.values(history.state).join(":"))//on garde le centre en local pour ne pas le perdre après refresh de la page
      this.centreData = Object.values(history.state) //Object.values() permet de récupérer notre object state et de le convertir en array 
      console.log(this.centreData)
      console.log(localStorage.getItem("centreData"))
      this.CenterManagementService.getAppointment(this.centreData.id).
        subscribe(appointment => this.appointments = appointment);
    }
    else {
      this.centreData = localStorage.getItem("centreData")?.split(":")
    }
  }

  delRdv(idRdv: number) {
    console.log("so long rdv n " + idRdv)
  }

}
