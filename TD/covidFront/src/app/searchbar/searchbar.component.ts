import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Center } from '../interface/Center';
import { SearchbarService } from './searchbar.service';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})

export class SearchbarComponent implements OnInit {

  centres:Center [] = [];
  private searchTerms = new Subject<string>();

  constructor(private searchbarService : SearchbarService){

  }

  ngOnInit(): void {
    this.getCentres()
  }

  getCentres(): void {
    this.searchbarService.getCentres().
    subscribe(centres => this.centres = centres);
    console.log('test' + this.centres);
  }

  search(term : string): void {
    this.searchTerms.next(term);
  }
}
