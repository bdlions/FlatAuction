import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/manage-product-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {ManageProductApp} from '../ManageProductApp';
//import {App} from './app';
import {DashBoard} from "../manageproduct/dashboard";
//import {Abroad} from './abroad';
//import {Header} from './header';
import {CarouselModule, TypeaheadModule, DatepickerModule} from "ngx-bootstrap"

@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        CarouselModule.forRoot(), TypeaheadModule.forRoot(),
        DatepickerModule.forRoot(),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [ManageProductApp, DashBoard],
    bootstrap: [ManageProductApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class ManageProductAppModule {}
