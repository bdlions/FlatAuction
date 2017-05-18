import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {AccountSettingFA} from '../dto/AccountSettingFA';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/featuredad/faq.html",
    providers: [WebAPIService]
})
export class Faq implements OnInit, OnDestroy {
    private webAPIService: WebAPIService;
    private accountSettingFA: AccountSettingFA;
    
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.accountSettingFA = new AccountSettingFA();
        /*this.accountSettingFA.defaultBidPerClick = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"9.60\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}");
        this.accountSettingFA.dailyBudget = JSON.parse("{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}");
        this.accountSettingFA.campainActive = true;*/
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_ACCOUNT_SETTING_FA)).then(result => {
            this.accountSettingFA = result;
        });    
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
