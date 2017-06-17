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
import {DashBoard} from "../member/dashboard";
import {MyHome} from "../home/myhome";
import {MyProduct} from "../manageproduct/myproduct";
import {MyAds} from "../member/myads";
import {SavedAds} from "../member/savedads";
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
import {BasicSearch} from "../common/basicsearch";
import {AdvancedSearch} from "../common/advancedsearch";
import {AppHeader} from '../member/header';
import {AppFooter} from '../member/footer';
import {Logout} from '../common/logout';
import {FileUploadModule } from 'ng2-file-upload';
import {CarouselModule, TypeaheadModule, DatepickerModule} from "ngx-bootstrap"
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        CarouselModule.forRoot(), TypeaheadModule.forRoot(),
        DatepickerModule.forRoot(),
        FileUploadModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [MemberApp, DashBoard, MyHome, MyProduct, MyAds, SavedAds, Inbox, Sent, Saved, Showmessage, Notifications, MyProfile, EditProfile, UploadImg, UploadDocument, BasicSearch, AdvancedSearch, AppHeader, AppFooter, Logout],
    bootstrap: [MemberApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class MemberAppModule {}
