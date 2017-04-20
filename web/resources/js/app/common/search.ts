import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';
import {Location} from '../dto/Location';
import {Price} from '../dto/Price';
import {General} from '../dto/General';


@Component({
    selector: 'data-content',
    templateUrl: "./../../../../html_components/public/search.html",
})
export class Search implements OnInit, OnDestroy {
    private locationList: Location[];
    private radiusList: General[];
    private minPriceList: Price[];
    private maxPriceList: Price[];  
    private productTypeList: General[];  
    private occupationList: General[];
    private genderList: General[];
    private roomSizeList: General[];
    
    private productList: Product[];
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router: ActivatedRoute) {
        this.locationList = JSON.parse("[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\"}]");
        this.radiusList = JSON.parse("[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]");
        this.minPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Min Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        this.maxPriceList = JSON.parse("[{\"id\":\"1\",\"symbol\":\"\",\"amount\":\"Max Price\"}, {\"id\":\"2\",\"symbol\":\"£\",\"amount\":\"500\"}, {\"id\":\"3\",\"symbol\":\"£\",\"amount\":\"600\"}]");
        this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]");
        this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]");
        this.genderList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]");
        this.roomSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]");
        
        this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        console.log(this.productList);
    }
    
    ngOnInit() {
        this.subscribe = this.router.params.subscribe(params => {
            this.id = params['id']; 
            console.log(this.id);
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}
