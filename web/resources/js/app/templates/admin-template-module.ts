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
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [AdminApp, Login, Users, Products, Locations, DashBoard],
    bootstrap: [AdminApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class AdminAppModule {}
