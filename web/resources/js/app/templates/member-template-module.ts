import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/member-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import {Router} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
//
import {MemberApp} from '../MemberApp';
//import {App} from './app';
import {Search} from '../common/search';
import {DashBoard} from "../member/dashboard";
import {MyHome} from "../home/myhome";
import {MyProduct} from "../manageproduct/myproduct";
import {MyAds} from "../member/myads";
import {SavedAds} from "../member/savedads";
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Fafaq} from "../featuredad/fafaq";
//import {Messages} from "../member/messages";
import {Inbox} from "../message/inbox";
import {Sent} from "../message/sent";
import {Saved} from "../message/saved";
import {Showmessage} from "../message/showmessage";
import {Notifications} from "../account/notifications";
import {MyProfile} from "../profile/myprofile";
import {EditProfile} from "../profile/editprofile";
import {UploadImg} from "../profile/uploadimg";
import {UploadDocument} from "../profile/uploaddocument";
import {UploadLogo} from "../profile/uploadlogo";
import {BasicSearch} from "../common/basicsearch";
import {AdvancedSearch} from "../common/advancedsearch";
import {AppHeader} from '../member/header';
import {AppFooter} from '../member/footer';
import {Terms} from '../common/terms';
import {Privacypolicy} from '../common/privacypolicy';
import {Contactus} from '../common/contactus';
import {Aboutus} from '../common/aboutus';
import {Faq} from '../common/faq';
import {Logout} from '../common/logout';
import {MemberHeaderMenuManager} from '../services/MemberHeaderMenuManager';
import {FileUploadModule } from 'ng2-file-upload';
import { AgmCoreModule } from 'angular2-google-maps/core';
import {CarouselModule, TypeaheadModule, DatepickerModule, ModalModule} from "ngx-bootstrap"
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        CarouselModule.forRoot(), TypeaheadModule.forRoot(),
            DatepickerModule.forRoot(), ModalModule.forRoot(),
        FileUploadModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyBQwFpi-R6gtguRzwSPzy4D0kyULz4ICd4'
        }),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [MemberApp, Search, DashBoard, MyHome, MyProduct, MyAds, SavedAds, Productinfo, Bids, AccountSettings, IndividualAdBids, Stats, Ranking, Fafaq, Inbox, Sent, Saved, Showmessage, Notifications, MyProfile, EditProfile, UploadImg, UploadDocument, UploadLogo, BasicSearch, AdvancedSearch, AppHeader, AppFooter, Terms, Privacypolicy, Contactus, Aboutus, Faq, Logout],
    bootstrap: [MemberApp],
    providers: [AuthGuard, MemberHeaderMenuManager, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class MemberAppModule {}
