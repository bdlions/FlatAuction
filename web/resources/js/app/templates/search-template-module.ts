import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/search-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {SearchApp} from '../SearchApp';
//import {App} from './app';
import {BasicSearch} from "../common/basicsearch";
import {AdvancedSearch} from "../common/advancedsearch";
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
    declarations: [SearchApp, BasicSearch, AdvancedSearch],
    bootstrap: [SearchApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class SearchAppModule {}
