import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
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
    
    constructor(public router: ActivatedRoute) {
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
