import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../../html_components/public/search.html",
})
export class Search implements OnInit, OnDestroy {
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router: ActivatedRoute) {
    }
    
    ngOnInit() {
        this.subscribe = this.router.params.subscribe(params => {
            this.id = params['id']; 
            console.log(this.id);
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}
