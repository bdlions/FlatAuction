import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
//import {Product} from '../dto/Product'
import { FileUploader } from 'ng2-file-upload';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    templateUrl: window.SUB_DIRECTORY + "/html_components/public/login.html",
    providers: [WebAPIService]
})

export class Login {
    private webAPIService: WebAPIService;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;

    }
    
}


