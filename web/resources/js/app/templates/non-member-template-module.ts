import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/non-member-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
import {NonMemberApp} from '../NonMemberApp';
import {Signup} from '../member/signup';
import {Landing} from '../member/landing';
import {BasicSearch} from '../common/basicsearch';
import {AdvancedSearch} from '../common/advancedsearch';
import {Search} from '../common/search';
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {CarouselModule, TypeaheadModule, DatepickerModule} from "ngx-bootstrap"
import {FileUploadModule } from 'ng2-file-upload';
import { AgmCoreModule } from 'angular2-google-maps/core';

@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule, 
        CarouselModule.forRoot(), TypeaheadModule.forRoot(),
        DatepickerModule.forRoot(),
        FileUploadModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyBQwFpi-R6gtguRzwSPzy4D0kyULz4ICd4'
        }),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [Signup, NonMemberApp, Landing, BasicSearch, AdvancedSearch, Search, Productinfo, Bids],
    bootstrap: [NonMemberApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class NonMemberAppModule {}
