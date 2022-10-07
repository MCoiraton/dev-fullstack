import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs'
import { CenterList } from '../interface/CenterList';
import { CenterlistService } from './centerlist.service';

@Component({
  selector: 'app-centerlist',
  templateUrl: './centerlist.component.html',
  styleUrls: ['./centerlist.component.css'],
})
export class CenterlistComponent implements OnInit {
  
  ville!: string;
  private sub:any;

  constructor(private service:CenterlistService, private route:ActivatedRoute) {
   
   }
  
  centers: CenterList = {
    centerList : new Array,  
  }



  
  
  ngOnInit(): void {
    this.sub=this.route.params.subscribe(params=>{
      this.ville=params['ville'];
    });
    this.service.getAllCentersCity(this.ville).subscribe(resultCenters=>{
      console.log(resultCenters);
      resultCenters.forEach(element => {
        this.centers.centerList.push(element)        
      });
    })
  }

}
