import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {Http} from '@angular/http';
import {User} from '../../dto/User'
import {Role} from '../../dto/Role'
import {WebAPIService} from './../../webservice/web-api-service';
import {PacketHeaderFactory} from './../../webservice/PacketHeaderFactory';
import {ACTION} from './../../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/admin/user/userinfo.html",
    providers: [WebAPIService]
})
export class Userinfo implements OnInit, OnDestroy {
    private webAPIService: WebAPIService;
    private subscribe:Subscription;
    private user: User;
    private roleList: Role[];
    private rolesString: string;
    private id:number;
    constructor(public router: Router, public route: ActivatedRoute, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
            this.user = new User();
            this.user.id = this.id;
            this.roleList = new Array<Role>();
            let requestBody: string = JSON.stringify(this.user);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_USER_INFO), requestBody).then(result => {
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
        });
    }
    
    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}

