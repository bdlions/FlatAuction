import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {Product} from '../dto/Product'
import {General} from '../dto/General'
import {Location} from '../dto/Location'
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/manageproduct/index.html",
    providers: [WebAPIService]
})
export class DashBoard {
    private webAPIService: WebAPIService;
    private product: Product;
    private roomList: General[];
    private productSizeList: General[];
    private productTypeList: General[];
    private durationList: General[];
    private areaList: Location[];
    private amenityList: General[];
    private occupationList: General[];
    private smokingList: General[];
    private petList: General[];
    private minStayList: General[];
    private maxStayList: General[];
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.product = new Product();
        this.roomList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Room\"}, {\"id\":\"2\",\"title\":\"2 Room\"}, {\"id\":\"3\",\"title\":\"3 Room\"}, {\"id\":\"4\",\"title\":\"4 Room\"}, {\"id\":\"5\",\"title\":\"5 Room\"}]");
        this.productSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Bed\"}, {\"id\":\"2\",\"title\":\"2 Bed\"}, {\"id\":\"3\",\"title\":\"3 Bed\"}, {\"id\":\"4\",\"title\":\"4 Bed\"}, {\"id\":\"5\",\"title\":\"5 Bed\"}]");
        this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Flat/Apartment\"}, {\"id\":\"2\",\"title\":\"House\"}, {\"id\":\"3\",\"title\":\"Property\"}]");
        this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        this.areaList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
        this.amenityList = JSON.parse("[{\"id\":\"1\",\"title\":\"Parking\"}, {\"id\":\"2\",\"title\":\"Balcony/patio\"}, {\"id\":\"3\",\"title\":\"Garden/roof terrace\"}, {\"id\":\"4\",\"title\":\"Disabled access\"}, {\"id\":\"5\",\"title\":\"Garage\"}]");
        this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"Student\"}, {\"id\":\"3\",\"title\":\"Professional\"}]");
        this.smokingList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"No\"}]");
        this.petList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"No\"}]");
        this.minStayList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Minimum\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"3\",\"title\":\"2 Day\"}, {\"id\":\"4\",\"title\":\"3 Day\"}, {\"id\":\"5\",\"title\":\"1 Week\"}, {\"id\":\"6\",\"title\":\"2 Week\"}, {\"id\":\"7\",\"title\":\"1 Month\"}, {\"id\":\"8\",\"title\":\"2 Month\"}]");
        this.maxStayList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Maximum\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"3\",\"title\":\"2 Day\"}, {\"id\":\"4\",\"title\":\"3 Day\"}, {\"id\":\"5\",\"title\":\"1 Week\"}, {\"id\":\"6\",\"title\":\"2 Week\"}, {\"id\":\"7\",\"title\":\"1 Month\"}, {\"id\":\"8\",\"title\":\"2 Month\"}]");
    }
    
    addProduct(event: Event) 
    {
        let requestBody: string = JSON.stringify(this.product);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_PRODUCT), requestBody).then(result =>{
            let response  = result;
            if (response.success){
                //show success message
            }
            else{
                //show error message at this page
            }
        });
    }
    
}
