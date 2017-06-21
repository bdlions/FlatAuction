import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';

@Component({
    selector: 'app-header',
    templateUrl: window.SUB_DIRECTORY +"/templates/member/header.html",
    providers: [WebAPIService]
})
export class AppHeader {
    private webAPIService: WebAPIService;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
    }
    
    dashboard(event: Event) {
        event.preventDefault();
        this.router.navigate(['']);
    }
    
    myhome(event: Event) {
        event.preventDefault();
        this.router.navigate(['myhome']);
    }
    
    myads(event: Event) {
        event.preventDefault();
        this.router.navigate(['myads']);
    }
    
//    savedads(event: Event) {
//        event.preventDefault();
//        this.router.navigate(['savedads']);
//    }
    
    inbox(event: Event) {
        event.preventDefault();
        this.router.navigate(['inbox']);
    }
    
    notifications(event: Event) {
        event.preventDefault();
        this.router.navigate(['notifications']);
    }
    
    myprofile(event: Event) {
        event.preventDefault();
        this.router.navigate(['myprofile']);
    }
    
    basicsearch(event: Event) {
        event.preventDefault();
        this.router.navigate(['basicsearch']);
    }
    
    logout(event: Event) {
        event.preventDefault();
        this.router.navigate(['logout']);
    }
}
