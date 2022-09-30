import { Component, OnInit } from "@angular/core";

@Component({
    selector:'home-search',
    template: ''
})

export class SearchComponent implements OnInit {

    search = "entrez votre ville";
    constructor() { }
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
}
