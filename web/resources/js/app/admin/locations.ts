import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Location} from '../dto/Location';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/admin/locations.html",
    providers: [WebAPIService]
})
export class Locations {
    private webAPIService: WebAPIService;
    private locationList: Location[];
    constructor(public router: Router, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            this.locationList = result.locations;
        });
    }
    
}
