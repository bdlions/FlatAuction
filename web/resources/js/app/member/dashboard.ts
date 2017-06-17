import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import {ServerResponse} from './../common/ServerResponse';
import {SignInResponse} from './../common/SignInResponse';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/dashboard.html",
    providers: [WebAPIService]
})
export class DashBoard {
    private webAPIService: WebAPIService;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        let fbEmail = localStorage.getItem("fbEmail");
        let password = localStorage.getItem("password");
        if (fbEmail != null && fbEmail != "")
        {
            let username = fbEmail;
            let requestBody: string = "{\"userName\": \"" + username + "\", \"password\": \"" + password+"\"}";
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.SIGN_IN), requestBody).then(result =>{
                let response:ServerResponse  = <ServerResponse>result;
                if (response.success){
                    let signInResponse: SignInResponse = <SignInResponse> result;
                    if (signInResponse.sessionId != null && signInResponse.sessionId != ""){
                        localStorage.removeItem("fbEmail");
                        localStorage.removeItem("password");
                        
                        localStorage.setItem("username", username);
                        localStorage.setItem("password", password);
                        localStorage.setItem("sessionId", signInResponse.sessionId);
                    }
                }
            });
        }
        console.log(fbEmail);
        //if there is valid fbEmail then call the server for auto login and clear fbemail from ls
    }
    
    dashboard(event: Event) {
        event.preventDefault();
        this.router.navigate(['dashboard']);
    }
    
//    myads(event: Event) {
//        event.preventDefault();
//        this.router.navigate(['myads']);
//    }
//    
//    savedads(event: Event) {
//        event.preventDefault();
//        this.router.navigate(['savedads']);
//    }
    
    messages(event: Event) {
        event.preventDefault();
        this.router.navigate(['messages']);
    }
}
