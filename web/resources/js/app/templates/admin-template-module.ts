import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/admin-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {AdminApp} from '../AdminApp';
//import {App} from './app';
import {Login} from '../admin/login';
import {DashBoard} from "../admin/dashboard";
import {Users} from "../admin/users";
import {Products} from "../admin/products";
import {Locations} from "../admin/locations";
import {Logout} from '../admin/logout';
//import {Abroad} from './abroad';
//import {Header} from './header';

import {CarouselModule, TypeaheadModule, DatepickerModule, ModalModule} from "ngx-bootstrap"


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        CarouselModule.forRoot(), TypeaheadModule.forRoot(),
        DatepickerModule.forRoot(), ModalModule.forRoot(),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [AdminApp, Users, Products, Locations, DashBoard, Logout],
    bootstrap: [AdminApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class AdminAppModule {}
