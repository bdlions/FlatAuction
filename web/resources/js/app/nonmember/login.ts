import {Component, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
//import {Product} from '../dto/Product'
import { FileUploader } from 'ng2-file-upload';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import {ServerResponse} from './../common/ServerResponse';
import {SignInResponse} from './../common/SignInResponse';
import { ModalDirective } from 'ngx-bootstrap';

@Component({
    templateUrl: window.SUB_DIRECTORY + "/html_components/public/login.html",
    providers: [WebAPIService]
})

export class Login {
    private webAPIService: WebAPIService;
    private errorMsg:string;
    private msg:string;
    @ViewChild('childModal') public childModal:ModalDirective;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        
        let username = localStorage.getItem("username");
        let password = localStorage.getItem("password");
        
        if (username != null && username != "" && password != null && password != ""){
            this.loginUser(username,password);
        }
    }
    public showChildModal(): void {
        this.childModal.show();
    }

    public hideChildModal(): void {
        this.childModal.hide();
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
}


