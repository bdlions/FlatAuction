import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Location} from '../dto/Location';
import {RankingFA} from '../dto/RankingFA';


import {AccountSettingFA} from '../dto/AccountSettingFA';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/featuredad/ranking.html",
    providers: [WebAPIService]
})
export class Ranking implements OnInit, OnDestroy {
    
    private locationList: Location[];
    private rankingList: RankingFA[];
    
    private webAPIService: WebAPIService;
    private accountSettingFA: AccountSettingFA;
    
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
        this.rankingList = JSON.parse("[{\"rankId\":\"1\", \"product\":{\"title\":\"Property 1\",\"location\":{\"postCode\":\"LU4 0HL\"}},\"currentBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"1\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}},\"topBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"11\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}, {\"rankId\":\"2\", \"product\":{\"title\":\"Property 2\",\"location\":{\"postCode\":\"LU4 0HL\"}},\"currentBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"2\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}},\"topBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"22\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}, {\"rankId\":\"3\", \"product\":{\"title\":\"Property 2\",\"location\":{\"postCode\":\"LU4 0HL\"}},\"currentBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"3\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}},\"topBid\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"33\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}]");
          
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
