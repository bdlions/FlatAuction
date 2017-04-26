import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {Product} from './dto/Product';

@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY + "/html_components/public/app.html",
})
export class NonMemberApp {
    constructor(public router: Router) {

    }
}


