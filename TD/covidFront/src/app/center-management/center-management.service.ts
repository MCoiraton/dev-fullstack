import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Appointment } from '../interface/Appointment';

@Injectable({
  providedIn: 'root'
})
export class CenterManagementService {

  constructor(private http: HttpClient) { }

  getAppointment(id: number): Observable<Appointment[]> {
    console.log(`http://localhost:8080/public/rdvs/${id}`)
    return this.http.get<Appointment[]>(`http://localhost:8080/public/rdvs/${id}`)
    
}
}
