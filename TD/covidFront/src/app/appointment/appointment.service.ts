import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient} from '@angular/common/http';
import { Appointment } from "../interface/Appointment";

@Injectable({
    providedIn:'root'//a changer
})
export class AppointmentService{
    constructor(private httpClient :HttpClient){}
    
    createAppointment(appointment:Appointment):Observable<Appointment>{
        return this.httpClient.post("")
    }
}