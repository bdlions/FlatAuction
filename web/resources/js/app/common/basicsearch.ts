import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
//import {Http} from '@angular/http';
//import {Subscription} from 'rxjs';
//import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import {ProductType} from '../dto/ProductType'
import {SearchParams} from '../dto/SearchParams';
//import {Price} from '../dto/Price';
//import {General} from '../dto/General';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/public/basicsearch.html",
    providers: [WebAPIService]
})
export class BasicSearch{
    private webAPIService: WebAPIService;
    private locationList: Location[];
    //private radiusList: General[];
    //private minPriceList: Price[];
    //private maxPriceList: Price[];  
    private productTypeList: ProductType[];  
    //private occupationList: General[];
    //private genderList: General[];
    //private roomSizeList: General[];
    //private durationList: General[];
    
    //private productList: Product[];
    //private subscribe:Subscription;
    //private id:number;
    private selectedLocation: Location;
    private searchParams: SearchParams;
    private referenceId:string;
    
    private fetchLocationCounter:number = 0;
    private fetchProductTypeCounter:number = 0;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.searchParams = new SearchParams();
        this.referenceId = "";
        this.fetchLocationList();
        this.fetchProductTypeList();
        //this.locationList = JSON.parse("[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\"}]");
        //this.radiusList = JSON.parse("[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]");
        //this.minPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Min Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        //this.maxPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Max Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        //this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]");
        //this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]");
        //this.genderList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]");
        //this.roomSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]");
        //this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        
        //this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        //console.log(this.productList);
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
//            this.locationList = result.locations;
//        });
        
        //this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_RADIUS_LIST)).then(result => {
        //    this.radiusList = result.radiuses;
        //});
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
//            this.productTypeList = result.productTypes;
//        });
    }
    
    public fetchLocationList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            if(result.success)
            {
                this.locationList = result.locations;
            }
            else
            {
                this.fetchLocationCounter++;
                if (this.fetchLocationCounter <= 5)
                {
                    this.fetchLocationList();
                }
            }            
        });
    }
    
    public fetchProductTypeList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
            if(result.success)
            {
                this.productTypeList = result.productTypes;
            }
            else
            {
                this.fetchProductTypeCounter++;
                if (this.fetchProductTypeCounter <= 5)
                {
                    this.fetchProductTypeList();
                }
            }
            
        });
    }
    
    
//    public selectProduct(event: Event, id: number){
//        this.router.navigate(['productinfo', {id: this.id }]);
//    }
    
//    ngOnInit() {
//        this.subscribe = this.route.params.subscribe(params => {
//            this.id = params['id']; 
//            console.log(this.id);
//            
//            
//        }); 
//    }
//
//    ngOnDestroy() {
//        this.subscribe.unsubscribe();
//    }
    
//    sent(event: Event) {
//        event.preventDefault();
//        this.router.navigate(['sent']);
//    }
    
    search(event: Event) {
        event.preventDefault();
        //console.log(this.selectedLocation);
        //forward search params into search page....
        //set search params into local storage
        if (this.searchParams.referenceId != null && this.searchParams.referenceId != "")
        {
            localStorage.setItem("referenceId", this.searchParams.referenceId);
        }
        if (this.searchParams.productType != null && this.searchParams.productType.id  != 0)
        {
            localStorage.setItem("productTypeId", this.searchParams.productType.id+"");
        }
//        if (this.searchParams.location != null && this.searchParams.location.id  != 0)
//        {
//            localStorage.setItem("locationId", this.searchParams.location.id+"");
//        }
        let id:number;
        id = 1;
        this.router.navigate(['search', {id: id}]);
    }
    
    basicsearch(event: Event) {
        event.preventDefault();
        this.router.navigate(['basicsearch']);
    }
    advancedsearch(event: Event) {
        event.preventDefault();
        this.router.navigate(['advancedsearch']);
    }
}
