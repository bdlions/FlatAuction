import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {WebAPIService} from './../webservice/web-api-service';
import {MemberHeaderMenuManager} from "../services/MemberHeaderMenuManager";

@Component({
    selector: 'app-header',
    templateUrl: window.SUB_DIRECTORY +"/templates/member/header.html",
    providers: [WebAPIService]
})
export class AppHeader{
    //private showNavBar: boolean = false;
    private activeMenu: string = "dashboard";
    private webAPIService: WebAPIService;
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService, private memberHeaderMenuManager: MemberHeaderMenuManager) {
        this.webAPIService = webAPIService;
        
//        this.memberHeaderMenuManager.showNavBarEmitter.subscribe((mode) => {
//            // mode will be null the first time it is created, so you need to igonore it when null
//            if (mode !== null) {
//                this.showNavBar = mode;
//            }
//        });
        this.memberHeaderMenuManager.menuActivationEmitter.subscribe((menuName) => {
            // mode will be null the first time it is created, so you need to igonore it when null
            if (menuName !== null) {
                this.activeMenu = menuName;
            }
        });       
    }
    
    goToMyhome(event: Event) {
        event.preventDefault();
        this.memberHeaderMenuManager.setActiveMenu("myhome");
        this.router.navigate(['myhome']);
    }
    
    goToContactus(event: Event) {
        event.preventDefault();
        this.memberHeaderMenuManager.setActiveMenu("contactus");
        this.router.navigate(['contactus']);
    }
    
    goToAboutus(event: Event) {
        event.preventDefault();
        this.memberHeaderMenuManager.setActiveMenu("aboutus");
        this.router.navigate(['aboutus']);
    }
    
    dashboard(event: Event) {
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("dashboard");
        this.router.navigate(['']);
    }
    
    myads(event: Event) {        
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("manageadvert");
        this.router.navigate(['myads']);
    }
    
    inbox(event: Event) {
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("messages");
        this.router.navigate(['inbox']);
    }
    
    notifications(event: Event) {
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("account");
        this.router.navigate(['notifications']);
    }
    
    myprofile(event: Event) {
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("profile");
        this.router.navigate(['myprofile']);
    }
    
    basicsearch(event: Event) {
        event.preventDefault();
        //this.memberHeaderMenuManager.showNavBar(true);
        this.memberHeaderMenuManager.setActiveMenu("search");
        this.router.navigate(['basicsearch']);
    }
    
    logout(event: Event) {
        event.preventDefault();
        this.router.navigate(['logout']);
    }
}
