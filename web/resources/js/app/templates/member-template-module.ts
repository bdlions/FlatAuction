import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/member-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {MemberApp} from '../MemberApp';
//import {App} from './app';
import {DashBoard} from "../member/dashboard";
import {SavedAds} from "../member/savedads";
import {MyAds} from "../member/myads";
import {Messages} from "../member/messages";
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [MemberApp, DashBoard, SavedAds, MyAds, Messages],
    bootstrap: [MemberApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class MemberAppModule {}
