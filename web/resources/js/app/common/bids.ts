import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Bid} from '../dto/Bid';
import {ProductBid} from '../dto/ProductBid';
import {Product} from '../dto/Product';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/public/bid.html",
    providers: [WebAPIService]
})
export class Bids implements OnInit, OnDestroy {
    private webAPIService: WebAPIService;
    private product: Product;
    private bidList: Bid[];
    private productBidList: ProductBid[];
    private subscribe:Subscription;
    //private id:number;
    //private productId:number;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        
        this.product = new Product();
        /*this.product.id = 1;
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
        this.product.timeLeft = "1 day 13 hours 30 mins";*/
        
        //this.bidList = JSON.parse("[{\"bidId\":\"1\",\"time\":\"21 Apr 2017 9:38:35AM\",\"amount\":\"1000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"bidId\":\"2\",\"time\":\"20 Apr 2017 9:38:35AM\",\"amount\":\"2000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}}]");
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_INFO)).then(result => {
//            this.product = result;
//        });
            
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_BID_LIST)).then(result => {
//            this.bidList = result.productBidList;
//        });
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            //this.id = params['id']; 
            //this.productId = params['id'];
            this.product = new Product();
            this.product.id =  params['id'];
            let requestBody: string = JSON.stringify(this.product);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_BID_LIST), requestBody).then(result => {
                this.productBidList = result.productBidList;
            });
            
            let requestBody2: string = JSON.stringify(this.product);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_INFO), requestBody2).then(result => {
                this.product = result;
            });
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    public selectProduct(event: Event, id: number){
        event.preventDefault();
        this.router.navigate(['productinfo', {id: id }]);
    }
}
