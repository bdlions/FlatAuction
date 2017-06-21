import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/app.html",
})
export class MemberApp {
    constructor(public router: Router) {
        
    }

}

