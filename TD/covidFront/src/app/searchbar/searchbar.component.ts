import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { AuthGuard } from '../guard/auth.guard';
import { Center } from '../interface/Center';
import { SearchbarService } from './searchbar.service';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})

export class SearchbarComponent implements OnInit {

  centres:Center [] = [];
  centres$!: Observable<Center[]>;
  private searchTerms = new Subject<string>();
  static router: any;
  constructor(private searchbarService : SearchbarService , private router:Router){
    
  }

  ngOnInit(): void {
    this.centres$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.searchbarService.searchCentres(term)),
    );
  }

  getCentres(): void {
    this.searchbarService.getCentres().
    subscribe(centres => this.centres = centres);
    console.log('test' + this.centres);
  }

  search(term : string): void {
    this.searchTerms.next(term);
  }

  onclick(centre:Center){
    if(localStorage.getItem('user')?.includes("ADMIN")){
      this.router.navigate(['admin/centerManagement',centre.centreId],{state:{id: centre.centreId, nom: centre.nom, adresse: centre.adresse}})
    }
    else this.router.navigate(['/appointment/', centre.centreId],{state:{id: centre.centreId, nom: centre.nom, adresse: centre.adresse}}) 
  }
}
