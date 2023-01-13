import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient} from '@angular/common/http';
import { Appointment } from "../interface/Appointment";

@Injectable({
    providedIn:'root'//a changer
})
export class AppointmentService{

    private urlPost = 'http://localhost:8080/api/appointment' //url pour le POST

    constructor(
        private httpClient: HttpClient){
        }
    
    createAppointment(appointment:any){
        return this.httpClient.post<Appointment[]>(this.urlPost, appointment)
    }
}