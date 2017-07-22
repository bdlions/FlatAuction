import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';
import {ProductBid} from '../dto/ProductBid';
import {Amenity} from '../dto/Amenity'
import {Message} from '../dto/Message';
import {MessageText} from '../dto/MessageText';

import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/public/product.html",
    providers: [WebAPIService]
})
export class Productinfo implements OnInit, OnDestroy {
    private webAPIService: WebAPIService;
    private requetProduct: Product;
    private productInfo: Product;
    private amenityList: Amenity[];
    private product: Product;
    private productBid:ProductBid;
    private subscribe:Subscription;
    private id:number;
    
    private newMessage:Message;
    private newMessageText:MessageText;
    private newMessageBody:string;
    private availabilityString:string;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        window.scrollTo(0, 0)
        this.webAPIService = webAPIService;
        
        this.amenityList = new Array<Amenity>();
        
        this.newMessage = new Message();
        this.newMessageText = new MessageText();
        this.newMessageBody = "";
        
        this.product = new Product();
        this.productBid = new ProductBid();
        this.product.id = 1;
        this.product.title = "Fun at the Bowling Alley";
        this.product.description = "Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR."
        this.product.price = 100;
        this.product.time = 1000;
        this.product.img = "a.jpg";
        this.product.type = 1;
        this.product.location_type = "location1";
        this.product.images = JSON.parse("[{\"id\":\"1\", \"title\":\"a.jpg\"}, {\"id\":\"2\", \"title\":\"b.jpg\"}]");
        this.product.totalBidders = 10;
        this.product.totalBids = 36;
        this.product.timeLeft = "1 day 13 hours 30 mins";
        this.product.startDate = "2017-05-11";
        this.product.endDate = "2017-05-15";
        
        
    }
    
    postBid(event: Event) 
    {
        let username = localStorage.getItem("username");
        if (username != null && username != "")
        {
            this.productBid.product = new Product();
            this.productBid.product.id = this.product.id;
            //ser user id from session at server
            //set currency and currency unit at server.
            let requestBody: string = JSON.stringify(this.productBid);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_PRODUCT_BID), requestBody).then(result =>{
                let response  = result;
                if (response.success){
                    this.productBid = new ProductBid();
                    //set a message that product bid is placed successfully
                }
                else{
                    //show error message at this page
                }
            });
        }
        else
        {
            //may redirected to login/signup page or show error messaage
        }
        
    }
    
    public showBids(event: Event, id: number){
        //retrieve bids from the server for this product
        this.router.navigate(['bids', {id: this.id }]);
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
            this.productInfo = new Product();
            this.requetProduct = new Product();
            this.requetProduct.id = this.id;
            let requestBody: string = JSON.stringify(this.requetProduct);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_INFO), requestBody).then(result => {
                this.productInfo = result;
                this.availabilityString = "";
                if (this.productInfo.availabilities.length > 0)
                {
                    for (let counter = 0; counter < this.productInfo.availabilities.length; counter++)
                    {
                        if (counter == 0)
                        {
                            this.availabilityString = this.productInfo.availabilities[counter].title;

                        }
                        else
                        {
                            this.availabilityString = this.availabilityString + ", " + this.productInfo.availabilities[counter].title;
                        }
                    }
                }
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_AMENITY_LIST)).then(result => {
                    if(result.amenities != null)
                    {
                        this.amenityList = result.amenities;
                        if (this.amenityList.length > 0)
                        {
                            for (let counter = 0; counter < this.amenityList.length; counter++)
                            {
                                this.amenityList[counter].status = "No";
                                if (this.productInfo.amenities.length > 0)
                                {
                                    for (let counter2 = 0; counter2 < this.productInfo.amenities.length; counter2++)
                                    {
                                        if (this.amenityList[counter].id == this.productInfo.amenities[counter2].id)
                                        {
                                            this.amenityList[counter].status = "Yes";
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            });
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    addmessage(event: Event) 
    {
        this.newMessageText = new MessageText();
        this.newMessageText.body = this.newMessageBody;
        
        this.newMessage.subject = "Re : " + this.productInfo.title;
        this.newMessage.product = this.productInfo;
        
        this.newMessage.messageTextList = new Array<MessageText>();
        this.newMessage.messageTextList[0] = this.newMessageText;
        let requestBody: string = JSON.stringify(this.newMessage);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_MESSAGE_INFO), requestBody).then(result => {
            this.newMessage = new Message();
            this.newMessageText = new MessageText();
            this.newMessageBody = "";
        });
    }
}
