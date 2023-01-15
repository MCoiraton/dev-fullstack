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
    console.log(`http://localhost:8080/admin/appointment/centre/${id}`)
    return this.http.get<Appointment[]>(`http://localhost:8080/admin/appointment/centre/${id}`)
}

  deleteAppointment(id: number){
    return this.http.delete<Appointment>(`http://localhost:8080/admin/appointment/${id}`)
  }
}
