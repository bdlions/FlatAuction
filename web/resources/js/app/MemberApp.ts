import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../html_components/public/index.html",
})
export class MemberApp {
    constructor(public router: Router, public http: Http) {
        
    }
    
//    signup(event: Event) {
//        event.preventDefault();
//        console.log("signup");
//        this.router.navigate(['signup']);
//    }
}

