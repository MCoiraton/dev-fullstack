import { Injectable } from "@angular/core";
import { catchError, Observable, map, tap, of } from "rxjs";
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { SearchAppointmentComponent } from "./search-appointment.component";
import { Center } from "../interface/Center";
import { Appointment } from "../interface/Appointment";

@Injectable({
    providedIn:'root'//a changer
})
export class SearchAppointmentService{
 
    private url = 'http://localhost:8080/public/rdvs'; //url pour le getRdvs
    private urlSearch = 'http://localhost:8080/public/rdvs' //url pour le search qui permet d'ajouter le paramètre de la ville

    constructor(
        private http: HttpClient){ 
        }       
   
    //On utilise un observable de notre interface pour pouvoir avoir un object qui prend en paramètres les variables de l'interface
    getAppointment(): Observable<Appointment[]> {
        return this.http.get<Appointment[]>(this.url)

    }

    //Pareil pour le search le premier if permet d'avoir un object nul vu qu'on refresh à chaque mise à jour du bloc recherche
    searchAppointment(term: string): Observable<Appointment[]> {
        if (!term.trim()) {
            return of([]);
        }
        console.log(`${this.urlSearch}/${term}`)
        return this.http.get<Appointment[]>(`${this.urlSearch}/${term}`)
        
    }

    vaccinatefdsf(idRdv:number): Observable<Appointment>{
        console.log(idRdv);
        console.log("vaccinated");
        return this.http.put<Appointment>(`http://localhost:8080/medecin/appointment/${idRdv}`, true);
    }
    
 
}
