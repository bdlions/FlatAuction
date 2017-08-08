import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import 'rxjs/Rx';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/home/index.html",
    providers: [WebAPIService]
})
export class MyHome {
    private webAPIService: WebAPIService;
    public selectedLocation:string;
    private locationList: Location[];
    private featuredProductList: Product[];
    
    constructor(public router: Router, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        //this.featuredProductList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}]");
        //this.locationList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_CLOSING_PRODUCT_LIST)).then(result => {
            this.featuredProductList = result.products;
            setInterval(() => 
                {
                    for (let counter = 0; counter < this.featuredProductList.length; counter++)
                    {
                        this.featuredProductList[counter].timeLeft = "";
                        let tempTime: number = this.featuredProductList[counter].time;
                        //if bid end time is over then we are not reducing time
                        if (tempTime > 0)
                        {
                            if (tempTime >= 86400)
                            {
                                this.featuredProductList[counter].timeLeft = this.featuredProductList[counter].timeLeft + Math.floor(tempTime/86400) + " days ";
                                tempTime = tempTime % 86400;
                            }
                            if (tempTime >= 3600)
                            {
                                this.featuredProductList[counter].timeLeft = this.featuredProductList[counter].timeLeft + Math.floor(tempTime/3600) + " hours ";
                                tempTime = tempTime % 3600;
                            } 
                            if (tempTime >= 60)
                            {
                                this.featuredProductList[counter].timeLeft = this.featuredProductList[counter].timeLeft + Math.floor(tempTime/60) + " mins ";
                                tempTime = tempTime % 60;
                            }
                            if (tempTime < 60)
                            {
                                this.featuredProductList[counter].timeLeft = this.featuredProductList[counter].timeLeft + tempTime + " secs ";
                            }                        
                            this.featuredProductList[counter].time = (this.featuredProductList[counter].time - 1);
                        }
                        
                    }                    
                }
            , 1000);
        });
    }
    
    search(event: Event, id: number) {
        event.preventDefault();
        this.router.navigate(['search', {id: id}]);
    }
    
    public selectProduct(event: Event, id: number) {
        this.router.navigate(['productinfo', {id: id}]);
    }
}
