import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'

@Component({
    selector: 'data-content1ddd',
    templateUrl: "./../../../../html_components/public/signup.html",
})
export class Signup {
    private user:User;
    constructor(public router: Router, public http: Http) {
        this.user = new User();
        this.user.firstName = "Alamgir";
    }
    registerUser(event:Event){
        event.preventDefault();
        console.log("User name: " + this.user.firstName + " " +this.user.lastName);
    }
}


