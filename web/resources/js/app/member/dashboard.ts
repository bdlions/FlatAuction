import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/dashboard.html",
})
export class DashBoard {
    
    constructor(public router: Router, public http: Http) {
        
    }
    
    dashboard(event: Event) {
        event.preventDefault();
        this.router.navigate(['dashboard']);
    }
    
    myads(event: Event) {
        event.preventDefault();
        this.router.navigate(['myads']);
    }
    
    savedads(event: Event) {
        event.preventDefault();
        this.router.navigate(['savedads']);
    }
    
    messages(event: Event) {
        event.preventDefault();
        this.router.navigate(['messages']);
    }
}
