import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../dto/Product';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/admin/products.html",
    providers: [WebAPIService]
})
export class Products {
    private webAPIService: WebAPIService;
    private productList: Product[];
    constructor(public router: Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_LIST)).then(result => {
            this.productList = result.products;
        });
    }
    
}
