import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {Location} from '../dto/Location';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/home/index.html",
})
export class DashBoard {
    public selectedLocation:string;
    private locationList: Location[];
    constructor(public router: Router, public http: Http) {
        this.locationList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
    }
    
    search(event: Event, id: number) {
        event.preventDefault();
        this.router.navigate(['search', {id: id}]);
    }
}
