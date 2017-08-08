import { NgModule, Component, Input, Output, EventEmitter, AfterViewInit , OnInit, OnDestroy} from '@angular/core';
import { DatePipe } from '@angular/common';

import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';

import {AccountSummaryFA} from '../dto/AccountSummaryFA';
import {Stat} from '../dto/Stat';
import {StatParams} from '../dto/StatParams';

import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import {Price} from '../dto/Price';
import {General} from '../dto/General';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/featuredad/stats.html",
    providers: [WebAPIService, DatePipe]
})
export class Stats implements OnInit, OnDestroy {
    private datePipe: DatePipe;
    private webAPIService: WebAPIService;
    private accountSummaryFA: AccountSummaryFA;
    private productList: Product[];
    private startDate:string;
    private endDate:string;
    private statList: Stat[];
    
    
    private locationList: Location[];
    private radiusList: General[];
    private minPriceList: Price[];
    private maxPriceList: Price[];  
    private productTypeList: General[];  
    private occupationList: General[];
    private genderList: General[];
    private roomSizeList: General[];
    private durationList: General[];
    
    
    private subscribe:Subscription;
    private id:number;
    
    public fromDate: Date = new Date();
    public toDate: Date = new Date();
    public minDate: Date = void 0;
    private showDatePicker: boolean = false;
    private showToDatePicker: boolean = false;
    private statParams: StatParams;
  
    constructor(public router: Router, public route: ActivatedRoute, webAPIService: WebAPIService, public datepipe: DatePipe) {
        this.webAPIService = webAPIService;
        this.datePipe = datepipe;
        this.statList = new Array<Stat>();
        this.statParams = new StatParams();
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_MY_PRODUCT_LIST)).then(result => {
            this.productList = result.products;
        });
        
        this.accountSummaryFA = new AccountSummaryFA();
        this.accountSummaryFA.totalBalance = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"9.60\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        this.accountSummaryFA.dailyBudget = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        this.accountSummaryFA.defaultBid = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"11\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}");
        this.accountSummaryFA.spentToday = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"0\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}");
        this.accountSummaryFA.leftToday = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        //this.statList = JSON.parse("[{\"date\":\"2017-07-14\",\"clicks\":\"5\",\"impressions\":\"20\",\"ctr\":\"20%\",\"cost\":\"9.60\"}, {\"date\":\"2017-07-13\",\"clicks\":\"9\",\"impressions\":\"30\",\"ctr\":\"25%\",\"cost\":\"7.70\"}, {\"date\":\"2017-07-12\",\"clicks\":\"15\",\"impressions\":\"70\",\"ctr\":\"50%\",\"cost\":\"5.10\"}]");
        //this.productList = JSON.parse("[{\"id\":\"0\",\"title\":\"All Adverts\"}, {\"id\":\"1\",\"title\":\"Advert1\"}, {\"id\":\"2\",\"title\":\"Advert2\"}, {\"id\":\"3\",\"title\":\"Advert3\"}]");
        
        //this.startDate = "2017-04-27";
        //this.endDate = "2017-04-27";
        //this.locationList = JSON.parse("[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\"}]");
        //this.radiusList = JSON.parse("[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]");
        //this.minPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Min Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        //this.maxPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Max Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        //this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]");
        //this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]");
        //this.genderList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]");
        //this.roomSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]");
        //this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        
        
        //console.log(this.productList);

        
    }
    
    searchStatList(event: Event) 
    {
        this.statParams = new StatParams();
        this.statParams.startDate = this.datepipe.transform(this.fromDate, 'yyyy-MM-dd');
        this.statParams.endDate = this.datepipe.transform(this.toDate, 'yyyy-MM-dd');
        let requestBody: string = JSON.stringify(this.statParams);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_STAT_LIST), requestBody).then(result => {
            this.statList = result.stats;
        });
    }
    
    
//    public selectProduct(event: Event, id: number){
//        this.router.navigate(['productinfo', {id: this.id }]);
//    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
            console.log(this.id);
            
            
        }); 
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    public myproduct(event: Event, id: number){
        event.preventDefault();
        this.router.navigate(['myproduct', {id: id }]);
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
    
    ranking(event: Event) {
        event.preventDefault();
        this.router.navigate(['ranking']);
    }
    
    fafaq(event: Event) {
        event.preventDefault();
        this.router.navigate(['fafaq']);
    }
    
    myads(event: Event) {
        event.preventDefault();
        this.router.navigate(['myads']);
    }
    
    savedads(event: Event) {
        event.preventDefault();
        this.router.navigate(['savedads']);
    }
}
