import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from '../interface/Center';
import { Location } from '@angular/common';


@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  centreData: any;

  constructor(private router: Router, private activatedRoute:ActivatedRoute) { 
    console.log(this.router.getCurrentNavigation()?.extras.state)
  }

  ngOnInit() {
    this.centreData = Object.values(history.state) //Object.values() permet de récupérer notre object state et de le convertir en array 
    console.log(this.centreData)
  }

}
