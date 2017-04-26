import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'

@Component({
    selector: 'data-content1ddd',
    templateUrl: "./../../../../html_components/member/dashboard.html",
})
export class DashBoard {
    
    constructor(public router: Router, public http: Http) {
        
    }
    
}
