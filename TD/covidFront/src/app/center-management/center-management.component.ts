import { Component, OnInit } from '@angular/core';
import { Observable, Subscribable } from 'rxjs';

@Component({
  selector: 'app-center-management',
  templateUrl: './center-management.component.html',
  styleUrls: ['./center-management.component.css']
})
export class CenterManagementComponent implements OnInit {
appointments$: Observable<undefined> | Subscribable<undefined> | Promise<undefined> | undefined;
  constructor() { }
  
  ngOnInit(): void {
  }

}
