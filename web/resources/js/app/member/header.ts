import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';

@Component({
    selector: 'app-header',
    templateUrl: window.SUB_DIRECTORY +"/templates/member/header.html",
    providers: [WebAPIService]
})
export class AppHeader{
    private webAPIService: WebAPIService;
    private dashboardSelected: boolean;
    private myadsSelected: boolean;
    private inboxSelected: boolean;
    private notificationSelected: boolean;
    private profileSelected: boolean;
    private basicSearchSelected:boolean;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        
        this.dashboardSelected = true;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
    }

    
    goToMyhome(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['myhome']);
    }
    
    goToContactus(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['contactus']);
    }
    
    goToAboutus(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['aboutus']);
    }
    
    dashboard(event: Event) {
        this.dashboardSelected = true;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['']);
    }
    
    myads(event: Event) {        
        this.dashboardSelected = false;    
        this.myadsSelected = true;    
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['myads']);
    }
    
    inbox(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = true;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['inbox']);
    }
    
    notifications(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = true;
        this.profileSelected = false;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['notifications']);
    }
    
    myprofile(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = true;
        this.basicSearchSelected = false;
        
        event.preventDefault();
        this.router.navigate(['myprofile']);
    }
    
    basicsearch(event: Event) {
        this.dashboardSelected = false;
        this.myadsSelected = false;
        this.inboxSelected = false;
        this.notificationSelected = false;
        this.profileSelected = false;
        this.basicSearchSelected = true;
        
        event.preventDefault();
        this.router.navigate(['basicsearch']);
    }
    
    logout(event: Event) {
        event.preventDefault();
        this.router.navigate(['logout']);
    }
}
