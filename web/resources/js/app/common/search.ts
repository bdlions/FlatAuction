import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../../html_components/public/search.html",
})
export class Search implements OnInit, OnDestroy {
    private productList: Product[];
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router: ActivatedRoute) {
        this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}]");
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
