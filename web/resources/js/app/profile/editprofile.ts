import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {Role} from '../dto/Role'
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/profile/editprofile.html",
    providers: [WebAPIService]
})
export class EditProfile {
    private webAPIService: WebAPIService;
    private user: User;
    private roles: Role[];
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.user = new User();
        this.roles = new Array<Role>();
        /*this.user.userId = "u1"; 
        this.user.firstName = "Nazmul";
        this.user.lastName = "Hasan";
        this.user.email = "bdlions@gmail.com";
        this.user.cellNo = "8801678112509";
        this.user.img = "user.jpg";
        this.user.document = "document.jpg";
        this.user.isVerified = true;*/
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_USER_INFO)).then(result => {
            this.user = <User>result;
        });
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_MEMBER_ROLES)).then(result => {
            if(result.roles != null)
            {
                this.roles = result.roles;
            }
        });
    }
    updateUserprofile(event: Event) {
        let requestBody: string = JSON.stringify(this.user);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.UPDATE_USER_INFO), requestBody).then(result =>{
            let response  = result;
            if (response.success){
                //show success message
                this.router.navigate(['myprofile']);
            }
            else{
                //show error message at this page
            }
        });
    }
    
    profile(event: Event) {
        event.preventDefault();
        this.router.navigate(['myprofile']);
    }
    
    
    myprofile(event: Event) {
        event.preventDefault();
        this.router.navigate(['myprofile']);
    }
    
    editprofile(event: Event) {
        event.preventDefault();
        this.router.navigate(['editprofile']);
    }
    
    uploadimg(event: Event) {
        event.preventDefault();
        this.router.navigate(['uploadimg']);
    }
    
    uploaddocument(event: Event) {
        event.preventDefault();
        this.router.navigate(['uploaddocument']);
    }
}
