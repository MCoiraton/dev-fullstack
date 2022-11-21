import { Injectable } from "@angular/core";
import { catchError, Observable, map, tap, of } from "rxjs";
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { SearchbarComponent } from "./searchbar.component";
import { Center } from "../interface/Center";

@Injectable({
    providedIn:'root'//a changer
})
export class SearchbarService{
 
    private url = 'http://localhost:8080/api/centres';

    constructor(
        private http: HttpClient){ 
        }       
   
    getCentres(): Observable<Center[]> {
        return this.http.get<Center[]>(this.url)
    }

    searchCentres(term: string): Observable<Center[]> {
        if (!term.trim()) {
            return of([]);
        }

        return this.http.get<Center[]>('${this.url}/?ville=${term}')
    }
    
 
}
