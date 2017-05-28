import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/account-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {AccountApp} from '../AccountApp';
//import {App} from './app';
import {Notifications} from "../account/notifications";
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
    declarations: [AccountApp, Notifications],
    bootstrap: [AccountApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class AccountAppModule {}
