import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import { FileUploader } from 'ng2-file-upload';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

const URL = window.SUB_DIRECTORY + '/FileUploadServlet';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/profile/uploadimg.html",
    providers: [WebAPIService]
})
export class UploadImg {
    public uploader:FileUploader = new FileUploader({url: URL});
    private webAPIService: WebAPIService;
    private user: User;
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.user = new User();
        /*this.user.userId = "u1"; 
        this.user.firstName = "Nazmul";
        this.user.lastName = "Hasan";
        this.user.email = "bdlions@gmail.com";
        this.user.cellNo = "8801678112509";
        this.user.img = "user.jpg";
        this.user.document = "document.jpg";
        this.user.isVerified = true;*/
        this.uploader.onCompleteItem = (item: any, response: any, status: any, headers:any)=>  {
            //console.log(response);
            //once image is uploaded then save it into the database
            this.user.img = response;
            let requestBody: string = JSON.stringify(this.user);
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.UPDATE_USER_PROFILE_PICTURE), requestBody).then(result =>{
                let response  = result;
                if (response.success){
                    //show success message
                    this.router.navigate(['myprofile']);
                }
                else{
                    //show error message at this page
                }
            });
        };
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_USER_INFO)).then(result => {
            this.user = result;
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
    
    uploadlogo(event: Event) {
        event.preventDefault();
        this.router.navigate(['uploadlogo']);
    }
}
