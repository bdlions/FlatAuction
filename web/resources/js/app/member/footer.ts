import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';


@Component({
    selector: 'app-footer',
    templateUrl: window.SUB_DIRECTORY +"/templates/member/footer.html",
    providers: [WebAPIService]
})
export class AppFooter {
    private webAPIService: WebAPIService;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
    }
    
    goToTerms(event: Event) {
        event.preventDefault();
        this.router.navigate(['terms']);
    }
    
    goToPrivacyPolicy(event: Event) {
        event.preventDefault();
        this.router.navigate(['privacypolicy']);
    }
    
    goToContactus(event: Event) {
        event.preventDefault();
        this.router.navigate(['contactus']);
    }
    
    goToFaq(event: Event) {
        event.preventDefault();
        this.router.navigate(['faq']);
    }
}
