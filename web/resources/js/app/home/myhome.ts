import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {Location} from '../dto/Location';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/home/index.html",
    providers: [WebAPIService]
})
export class MyHome {
    private webAPIService: WebAPIService;
    public selectedLocation:string;
    private locationList: Location[];
    constructor(public router: Router, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        //this.locationList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
    }
    
    search(event: Event, id: number) {
        event.preventDefault();
        this.router.navigate(['search', {id: id}]);
    }
}
