import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs'
import { CenterList } from '../interface/CenterList';

@Component({
  selector: 'app-centerlist',
  templateUrl: './centerlist.component.html',
  styleUrls: ['./centerlist.component.css'],
})
export class CenterlistComponent implements OnInit {
  
  ville!: string;
  private sub:any;

  constructor(private httpClient: HttpClient, private route:ActivatedRoute) {
   
   }
  
  centers: CenterList = {
    centerList : this.getAllCentersCity(this.ville);
  }

  getAllCentersCity(city : string) : Observable<CenterlistComponent[]>{
    return this.httpClient.get<CenterlistComponent[]>("api/centres")
  }
  ngOnInit(): void {
    this.sub=this.route.params.subscribe(params=>{
      this.ville=params['ville'];
    });
  }

}
