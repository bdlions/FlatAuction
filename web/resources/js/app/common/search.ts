import {Component, OnInit, OnDestroy, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
//import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import {ProductSize} from '../dto/ProductSize';
import {Pet} from '../dto/Pet';
import {Availability} from '../dto/Availability';
import {Currency} from '../dto/Currency';
import {General} from '../dto/General';
import {SavedProduct} from '../dto/SavedProduct';
import {SebmGoogleMap} from 'angular2-google-maps/core';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    styles:[
        `.sebm-google-map-container {
            height: 300px;
        }`
    ],
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY + "/html_components/public/search.html",
    providers: [WebAPIService]
})
export class Search implements OnInit, OnDestroy {
    private webAPIService: WebAPIService;
    private locationList: Location[];
    private productSizeList: ProductSize[];
    private availabilityList: Availability[];
    
    
    //private radiusList: General[];
    private minPriceList: Currency[];
    private maxPriceList: Currency[];
    private productTypeList: General[];
    private occupationList: General[];
    private petList: Pet[];
    
    //private genderList: General[];
    //private roomSizeList: General[];
    //private durationList: General[];
    
    private savedProduct: SavedProduct;

    private productList: Product[];
    private subscribe: Subscription;
    private id: number;
    private title: string = 'Property locations';
    private lat: number = 55.014566;
    private lng: number = -3.751245;
    
    @ViewChild(SebmGoogleMap) private sebmGoogMap: SebmGoogleMap;

    

    constructor(public router: Router, public route: ActivatedRoute, webAPIService: WebAPIService) {

        this.webAPIService = webAPIService;
        this.savedProduct = new SavedProduct();
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
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_LIST)).then(result => {
            this.productList = result.products;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
        
        //this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_RADIUS_LIST)).then(result => {
        //    this.radiusList = result.radiuses;
        //});
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_MIN_PRICE_LIST)).then(result => {
            this.minPriceList = result.prices;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_MAX_PRICE_LIST)).then(result => {
            this.maxPriceList = result.prices;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
            this.productTypeList = result.productTypes;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_SIZE_LIST)).then(result => {
            this.productSizeList = result.productSizes;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_OCCUPATION_LIST)).then(result => {
            this.occupationList = result.occupations;
        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PET_LIST)).then(result => {
            this.petList = result.pets;
        });
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_GENDER_LIST)).then(result => {
//            this.genderList = result.genders;
//        });
        
        
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_ROOM_SIZE_LIST)).then(result => {
//            this.roomSizeList = result.roomSizes;
//        });
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_AVAILABILITY_LIST)).then(result => {
            this.availabilityList = result.availabilities;
        });
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_DURATION_LIST)).then(result => {
//            this.durationList = result.durations;
//        });
        
//        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_LIST)).then(result => {
//            //this.productList = result.products;
//        });
        
        //console.log(this.productList);

    }

    public saveProduct(event: Event, id: number) {
        let username = localStorage.getItem("username");
        if (username != null && username != ""){
            let product: Product = new Product();
            product.id = id;
            this.savedProduct.product = product;
            let requestBody: string = JSON.stringify(this.savedProduct);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_SAVED_PRODUCT), requestBody).then(result => {
                //handle success or error message
                console.log(result);
            });
        }
        else
        {
            //may redirected to login/signup page or show error messaage
        }        
    }


    public selectProduct(event: Event, id: number) {
        this.router.navigate(['productinfo', {id: id}]);
    }

    doTriggerResize() {
        //this.sebmGoogMap.triggerResize();
    }

    ngOnInit() {
        this.sebmGoogMap.triggerResize();
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id'];
            console.log(this.id);
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}
