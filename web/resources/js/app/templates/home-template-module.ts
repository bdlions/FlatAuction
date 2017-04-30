import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/home-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {HomeApp} from '../HomeApp';
//import {App} from './app';
import {DashBoard} from "../home/dashboard";
//import {Abroad} from './abroad';
//import {Header} from './header';
import {TypeaheadModule} from "ngx-bootstrap"


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule, TypeaheadModule.forRoot(),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [HomeApp, DashBoard],
    bootstrap: [HomeApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class HomeAppModule {}
