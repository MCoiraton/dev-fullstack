import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs'
import { CenterList } from '../interface/CenterList';

@Component({
  selector: 'app-centerlist',
  templateUrl: './centerlist.component.html',
  styleUrls: ['./centerlist.component.css']
})
export class CenterlistComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }
  
  centers: CenterList = {
    centerList : 
  }

  getAllCentersCity(city : string) : Observable<CenterlistComponent[]>{
    return this.httpClient.get<CenterlistComponent[]>("api/centres")
  }
  ngOnInit(): void {
  }

}
