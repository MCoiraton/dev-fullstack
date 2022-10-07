import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs'

@Component({
  selector: 'app-centerlist',
  templateUrl: './centerlist.component.html',
  styleUrls: ['./centerlist.component.css']
})
export class CenterlistComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  getAllCentersCity(villes : string) : Observable<CenterlistComponent[]>{
    return this.httpClient.get<CenterlistComponent[]>("/centres", { 
      params: {
        "villes" : villes
      }
    }); 
  }
  ngOnInit(): void {
    
  }

}
