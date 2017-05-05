import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {Location} from '../dto/Location';
import {Product} from '../dto/Product';
import {Observable} from 'rxjs/Observable';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import {ServerResponse} from './../common/ServerResponse';
import {SignInResponse} from './../common/SignInResponse';

import 'rxjs/Rx';

@Component({
    selector: 'content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/public/landing.html",
    providers: [WebAPIService]
})

export class Landing {
    public selectedLocation:string;
    private locationList: Location[];
    private featuredProductList: Product[];  
    private webAPIService: WebAPIService;
    private errorMsg:string;
    
    constructor(public router: Router, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        //this.locationList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\",\"postCode\":\"c1\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\",\"postCode\":\"c2\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\",\"postCode\":\"c3\"}]");
        //this.featuredProductList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}]");

        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_LIST)).then(result => {
            this.featuredProductList = result.products;
        });
        
        let username = localStorage.getItem("username");
        let password = localStorage.getItem("password");
        
        if (username != null && username != "" && password != null && password != ""){
            this.loginUser(username,password);
        }
        
    }

    login(event: Event, username: string, password: string) {
        event.preventDefault();
        this.loginUser(username, password);
    }
    
    loginUser(username:string, password:string){
        let requestBody: string = "{\"userName\": \"" + username + "\", \"password\": \"" + password+"\"}";
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.SIGN_IN), requestBody).then(result =>{
            let response:ServerResponse  = <ServerResponse>result;
            if (response.success){
                let signInResponse: SignInResponse = <SignInResponse> result;
                if (signInResponse.sessionId != null && signInResponse.sessionId != ""){
                    localStorage.setItem("username", username);
                    localStorage.setItem("password", password);
                    localStorage.setItem("sessionId", signInResponse.sessionId);
                    window.location.replace("/");
                    window.location.href = "member.jsp";
                }
                else{
                    localStorage.removeItem("sessionId");
                    this.errorMsg = "Invalid session.";
                }
            }
            else{
                this.errorMsg = response.message;
            }
        });
        
    }

    signup(event: Event) {
        event.preventDefault();
        this.router.navigate(['signup']);
    }
    search(event: Event, id: number) {
        event.preventDefault();
        this.router.navigate(['search', {id: id}]);
    }
}



