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
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/profile/index.html",
    providers: [WebAPIService]
})
export class MyProfile {
    private webAPIService: WebAPIService;
    private user: User;
    private roleList: Role[];
    private rolesString: string;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.user = new User();
        this.roleList = new Array<Role>();
        /*this.user.userId = "u1"; 
        this.user.firstName = "Nazmul";
        this.user.lastName = "Hasan";
        this.user.email = "bdlions@gmail.com";
        this.user.cellNo = "8801678112509";
        this.user.img = "user.jpg";
        this.user.document = "document.jpg";
        this.user.isVerified = true;*/
        
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_USER_INFO)).then(result => {
            this.user = result;
            this.roleList = this.user.roleList;
            this.rolesString = "";
            if (this.roleList.length > 0)
            {
                for (let counter = 0; counter < this.roleList.length; counter++)
                {
                    if (counter == 0)
                    {
                        this.rolesString = this.roleList[counter].description;
                        
                    }
                    else
                    {
                        this.rolesString = this.rolesString + ", " + this.roleList[counter].description;
                    }
                }
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
