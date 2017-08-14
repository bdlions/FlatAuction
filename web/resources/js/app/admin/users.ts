import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../dto/User';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/admin/users.html",
    providers: [WebAPIService]
})
export class Users {
    private webAPIService: WebAPIService;
    private userList: User[];
    constructor(public router: Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_USER_LIST)).then(result => {
            this.userList = result.users;
        });
    }
    
    public selectUser(event: Event, id: number){
        event.preventDefault();
        this.router.navigate(['userinfo', {id: id }]);
    }
}
