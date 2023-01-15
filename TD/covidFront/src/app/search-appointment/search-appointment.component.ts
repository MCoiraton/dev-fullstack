import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { Appointment } from '../interface/Appointment';
import { Center } from '../interface/Center';
import { SearchAppointmentService } from './search-appointment.service';

@Component({
  selector: 'app-searchbar',
  templateUrl: './search-appointment.component.html',
  styleUrls: ['./search-appointment.component.css']
})

export class SearchAppointmentComponent implements OnInit {

  appointment:Appointment [] = [];
  appointments$!: Observable<Appointment[]>;
  private searchTerms = new Subject<string>();

  constructor(private SearchAppointmentService : SearchAppointmentService){

  }

  ngOnInit(): void {
    this.appointments$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.SearchAppointmentService.searchAppointment(term)),
    );
  }

  getAppointment(): void {
    this.SearchAppointmentService.getAppointment().
    subscribe(appointment => this.appointment = appointment);
    console.log('test' + this.appointment);
  }

  search(term : string): void {
    this.searchTerms.next(term);
  }

  vaccinate(idRdv:number){
   this.SearchAppointmentService.vaccinate(idRdv);
  }
}
