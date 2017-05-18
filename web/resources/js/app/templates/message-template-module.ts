import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/message-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {MessageApp} from '../MessageApp';
//import {App} from './app';
import {Inbox} from "../message/inbox";
import {Sent} from "../message/sent";
import {Saved} from "../message/saved";
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
    declarations: [MessageApp, Inbox, Sent, Saved],
    bootstrap: [MessageApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class MessageAppModule {}
