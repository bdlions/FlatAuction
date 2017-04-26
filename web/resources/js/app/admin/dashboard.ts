import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/admin/index.html",
})
export class DashBoard {
    
    constructor(public router: Router, public http: Http) {
        
    }
    
}
