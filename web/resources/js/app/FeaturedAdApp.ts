import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../html_components/public/app.html",
})
export class FeaturedAdApp {
    constructor(public router: Router) {
        
    }

}
