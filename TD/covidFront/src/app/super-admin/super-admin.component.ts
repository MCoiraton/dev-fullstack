import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { CenterlistService } from '../centerlist/centerlist.service';
import { Center } from '../interface/Center';
import { CenterList } from '../interface/CenterList';
import { User } from '../interface/User';
import { SearchbarService } from '../searchbar/searchbar.service';
import { SuperAdminService } from './super-admin.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.css']
})
export class SuperAdminComponent implements OnInit {
  centres: Center [] = [];
  centres$!: Observable<Center[]>;
  user!: User;
  users$!: Observable<User>;
  private searchTerms = new Subject<string>();
  private searchUserId = new Subject<string>();
  static router: any;
  status: string | undefined;
  loginForm: FormGroup | any;
  
  constructor(private searchbarService : SearchbarService , private router:Router, private SuperAdminService: SuperAdminService ){
    this.loginForm = new FormGroup({
      id: new FormControl('')})
  }

  ngOnInit(): void {
    this.centres$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.SuperAdminService.searchCentres(term))
    );
  }

  search(term : string): void {
    console.log(this.searchTerms)
    this.searchTerms.next(term);
  }

  searchUsers() {
    this.SuperAdminService.searchUser(this.loginForm.value.id).subscribe(user => {
      this.user = user;
      console.log(this.user);
      this.status = " Yep"});
   
  }

  onclick(centre:Center){
    if(localStorage.getItem('user')?.includes("ADMIN")){
      this.router.navigate(['admin/centerManagement',centre.centreId],{state:{id: centre.centreId, nom: centre.nom, adresse: centre.adresse}})
    }
    else this.router.navigate(['/appointment/', centre.centreId],{state:{id: centre.centreId, nom: centre.nom, adresse: centre.adresse}}) 
  }

  delCentre(idRdv: number) {
    console.log("so long centre n " + idRdv)
    this.SuperAdminService.deleteCentre(idRdv).subscribe(() => this.status = 'Delete Ok');
   
  }

  delUser(idUser:number){
    this.SuperAdminService.deleteUser(idUser).subscribe(() => this.status = 'Delete ok')
  }

}
