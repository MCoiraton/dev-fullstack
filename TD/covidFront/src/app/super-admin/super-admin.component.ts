import { Component, OnInit } from '@angular/core';
import { SuperAdminService } from './super-admin.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.css']
})
export class SuperAdminComponent implements OnInit {

  constructor(private SuperAdminService:SuperAdminService) { }

  ngOnInit(): void {
  }

}
