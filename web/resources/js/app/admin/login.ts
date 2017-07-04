import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import {ServerResponse} from './../common/ServerResponse';
import {SignInResponse} from './../common/SignInResponse';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY + "/html_components/admin/login.html",
    providers: [WebAPIService]
})

export class Login {
    private webAPIService: WebAPIService;
    private errorMsg:string;
    private msg:string;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        
        let username = localStorage.getItem("username");
        let password = localStorage.getItem("password");
        
        if (username != null && username != "" && password != null && password != ""){
            this.loginUser(username,password);
        }
    }
    
    login(event: Event, username: string, password: string) {
        if (username == null || username == "")
        {
            this.errorMsg = "Email is required.";
            return;
        }
        if (password == null || password == "")
        {
            this.errorMsg = "Password is required.";
        }
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
                    window.location.href = "admin.jsp";
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
}


