import { Injectable } from "@angular/core";
import { catchError, Observable, map, tap, of } from "rxjs";
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { SearchbarComponent } from "./searchbar.component";
import { Center } from "../interface/Center";

@Injectable({
    providedIn:'root'//a changer
})
export class SearchbarService{
 
    private url = 'http://localhost:8080/api/centres'; //url pour le getCentres
    private urlSearch = 'http://localhost:8080/api' //url pour le search qui permet d'ajouter le paramètre de la ville

    constructor(
        private http: HttpClient){ 
        }       
   
    //On utilise un observable de notre interface pour pouvoir avoir un object qui prend en paramètres les variables de l'interface
    getCentres(): Observable<Center[]> {
        return this.http.get<Center[]>(this.url)
    }

    //Pareil pour le search le premier if permet d'avoir un object nul vu qu'on refresh à chaque mise à jour du bloc recherche
    searchCentres(term: string): Observable<Center[]> {
        //mise en majuscule de la première lettre
        term=term.charAt(0).toUpperCase() + term.slice(1);
        if (!term.trim()) {
            return of([]);
        }
        console.log(`${this.urlSearch}/ville/${term}`)
        return this.http.get<Center[]>(`${this.urlSearch}/ville/${term}`)
        
    }
    
 
}
