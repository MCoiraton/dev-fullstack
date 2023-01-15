import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { CenterlistComponent } from '../centerlist/centerlist.component';
import { Center } from '../interface/Center';
import { User } from '../interface/User';

@Injectable({
  providedIn: 'root'
})
export class SuperAdminService {

  private url = 'http://localhost:8080/api/centres'; //url pour le getCentres
  private urlSearch = 'http://localhost:8080/api' //url pour le search qui permet d'ajouter le paramètre de la ville
  private urlUser = 'http://localhost:8080/superadmin/admin/'
    constructor(
        private http: HttpClient){ 
        }       

    searchUser(terms: number) {
      console.log(`${this.urlUser}${terms}`)
      return this.http.get<any>(`${this.urlUser}${terms}`);
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

    deleteCentre(id: number){
      return this.http.delete<Center>(`http://localhost:8080/superadmin/centres/${id}`)
    }

    deleteUser(id: number){
      return this.http.delete<User>(`http://localhost:8080/superadmin/admin/${id}`)
    }
}
