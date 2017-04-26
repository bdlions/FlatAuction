import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../../html_components/public/product.html",
})
export class Productinfo implements OnInit, OnDestroy {
    private product: Product;
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute) {
        this.product = new Product();
        this.product.id = 1;
        this.product.title = "Fun at the Bowling Alley";
        this.product.description = "Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR."
        this.product.price = 100;
        this.product.time = 1000;
        this.product.img = "a.jpg";
        this.product.type = 1;
        this.product.location_type = "location1";
        this.product.images = JSON.parse("[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}]");
        this.product.totalBidders = 10;
        this.product.totalBids = 36;
        this.product.timeLeft = "1 day 13 hours 30 mins";
        this.product.startDate = "2017-05-11";
        this.product.endDate = "2017-05-15";
    }
    
    public showBids(event: Event, id: number){
        this.router.navigate(['bids', {id: this.id }]);
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
}
