import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';

import {AccountSummaryFA} from '../dto/AccountSummaryFA';
import {Stat} from '../dto/Stat';

import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import {Price} from '../dto/Price';
import {General} from '../dto/General';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/featuredad/stats.html",
})
export class Stats implements OnInit, OnDestroy {
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
    public minDate: Date = void 0;
  
    constructor(public router:Router, public route: ActivatedRoute) {
        
        this.accountSummaryFA = new AccountSummaryFA();
        this.accountSummaryFA.totalBalance = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"9.60\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        this.accountSummaryFA.dailyBudget = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        this.accountSummaryFA.defaultBid = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"11\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}");
        this.accountSummaryFA.spentToday = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"0\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}");
        this.accountSummaryFA.leftToday = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        
        this.productList = JSON.parse("[{\"id\":\"0\",\"title\":\"All Adverts\"}, {\"id\":\"1\",\"title\":\"Advert1\"}, {\"id\":\"2\",\"title\":\"Advert2\"}, {\"id\":\"3\",\"title\":\"Advert3\"}]");
        
        this.startDate = "2017-04-27";
        this.endDate = "2017-04-27";
        this.statList = JSON.parse("[{\"date\":\"2017-04-27\",\"clicks\":\"5\",\"impressions\":\"20\",\"ctr\":\"20%\",\"cost\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"9.60\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}, {\"date\":\"2017-04-26\",\"clicks\":\"9\",\"impressions\":\"30\",\"ctr\":\"25%\",\"cost\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"7.10\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}, {\"date\":\"2017-04-25\",\"clicks\":\"15\",\"impressions\":\"70\",\"ctr\":\"50%\",\"cost\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"5.70\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}]");
        
        this.locationList = JSON.parse("[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\"}]");
        this.radiusList = JSON.parse("[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]");
        this.minPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Min Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        this.maxPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Max Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]");
        this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]");
        this.genderList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]");
        this.roomSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]");
        this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        
        
        console.log(this.productList);

        
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
    
    ranking(event: Event) {
        event.preventDefault();
        this.router.navigate(['ranking']);
    }
    
    faq(event: Event) {
        event.preventDefault();
        this.router.navigate(['faq']);
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
