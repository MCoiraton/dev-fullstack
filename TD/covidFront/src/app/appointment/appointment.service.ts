import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient} from '@angular/common/http';

@Injectable({
    providedIn:'root'//a changer
})
export class AppointmentService{
    constructor(private httpClient :HttpClient){}
    
}