import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
//import {Product} from '../dto/Product'
import { FileUploader } from 'ng2-file-upload';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

const URL = window.SUB_DIRECTORY + '/FileUploadServlet';

@Component({
    templateUrl: window.SUB_DIRECTORY + "/html_components/public/signup.html",
    providers: [WebAPIService]
})

export class Signup {
    private user:User;
    //private productList: Product[];
    public uploader:FileUploader = new FileUploader({url: URL});
    private webAPIService: WebAPIService;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        //this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        //this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_LIST)).then(result => {
        //    this.productList = result.products;
        //    console.log(result);
        //});
        this.user = new User();
        //this.user.firstName = "Alamgir";
    }
    registerUser(event:Event){
        //event.preventDefault();
        //console.log("User name: " + this.user.firstName + " " +this.user.lastName);
        //let requestBody: string = "{\"firstName\": \"" + this.user.firstName + "\",\"lastName\": \"" + this.user.lastName + "\",\"email\": \"" + this.user.email + "\", \"password\": \"" + this.user.password+"\"}";
        let requestBody: string = JSON.stringify(this.user);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.SIGN_UP), requestBody).then(result =>{
            let response  = result;
            if (response.success){
                localStorage.setItem("msg", "Account created successfully. Please login.");
                window.location.replace("/");
                window.location.href = "non-member.jsp";
            }
            else{
                //show error message at this page
            }
        });
    }
}


