import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/profile-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {ProfileApp} from '../ProfileApp';
//import {App} from './app';
import {DashBoard} from "../profile/dashboard";
import {EditProfile} from "../profile/editprofile";
import {UploadImg} from "../profile/uploadimg";
import {UploadDocument} from "../profile/uploaddocument";
import {FileUploadModule } from 'ng2-file-upload';
import {Logout} from '../common/logout';
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        FileUploadModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [ProfileApp, DashBoard, EditProfile, UploadImg, UploadDocument, Logout],
    bootstrap: [ProfileApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class ProfileAppModule {}
