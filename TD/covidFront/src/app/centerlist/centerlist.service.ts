import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient} from '@angular/common/http';
import { CenterlistComponent } from "./centerlist.component";

@Injectable({
    providedIn:'root'//a changer
})
export class CenterlistService{
    constructor(private httpClient : HttpClient){}

    getAllCentersCity(city : string) : Observable<CenterlistComponent[]>{
        return this.httpClient.get<CenterlistComponent[]>("api/centres")
    }
}