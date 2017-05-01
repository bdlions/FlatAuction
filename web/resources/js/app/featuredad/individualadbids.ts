import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';

import {Product} from '../dto/product';



@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/featuredad/individualadbids.html",
})
export class IndividualAdBids implements OnInit, OnDestroy {
    private productList: Product[];
    
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute) {
        this.productList = JSON.parse("[{\"id\":\"1\",\"isFeaturedAdd\":\"true\",\"isDefaultBid\":\"true\",\"title\":\"Property 1\",\"location\":{\"postCode\":\"LU4 0HL\"},\"adBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}}, {\"id\":\"2\",\"isFeaturedAdd\":\"true\",\"isDefaultBid\":\"true\",\"title\":\"Property 2\",\"location\":{\"postCode\":\"LU4 0HL\"},\"adBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"5\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}}, {\"id\":\"3\",\"isFeaturedAdd\":\"true\",\"isDefaultBid\":\"true\",\"title\":\"Property 3\",\"location\":{\"postCode\":\"LU4 0HL\"},\"adBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"6\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}}]");
    }
    
    
    public selectProduct(event: Event, id: number){
        this.router.navigate(['productinfo', {id: this.id }]);
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
            console.log(this.id);
            
            
        }); 
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    accountsettings(event: Event) {
        event.preventDefault();
        this.router.navigate(['accountsettings']);
    }
    
    individualadbids(event: Event) {
        event.preventDefault();
        this.router.navigate(['individualadbids']);
    }
    
    stats(event: Event) {
        event.preventDefault();
        this.router.navigate(['stats']);
    }
}
