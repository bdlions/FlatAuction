import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/public/index.html",
    providers: [WebAPIService]
})
export class Logout {
    private webAPIService: WebAPIService;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.SIGN_OUT)).then(result => {
            console.log(result);
        });
        //call server to logout
        //clear local storate
        localStorage.removeItem("username");
        localStorage.removeItem("password");
        localStorage.removeItem("sessionId");
        //redirect to non-member.jsp
        window.location.replace("/");
        window.location.href = "non-member.jsp";
    }
    
}
