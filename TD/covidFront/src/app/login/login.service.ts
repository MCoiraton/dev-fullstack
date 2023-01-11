import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private urlPostNewUser = 'http://localhost:8080/api/signup' //url pour le POST

    constructor(
        private httpClient: HttpClient){
        }
    
  login(login:any) {
    return this.httpClient.post<boolean>(this.urlPostNewUser, login)
  }
}
