import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';

@Component({
    selector: 'app-header',
    templateUrl: window.SUB_DIRECTORY +"/templates/public/header.html",
    providers: [WebAPIService]
})
export class AppHeader {
    private webAPIService: WebAPIService;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
    }
    
    goToLanding(event: Event) {
        event.preventDefault();
        this.router.navigate(['landing']);
    }
    
    goToSearch(event: Event) {
        event.preventDefault();
        this.router.navigate(['search']);
    }
    
    goToContactus(event: Event) {
        event.preventDefault();
        this.router.navigate(['contactus']);
    }
    
    goToAboutus(event: Event) {
        event.preventDefault();
        this.router.navigate(['aboutus']);
    }
}
