import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/featured-ad-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {FeaturedAdApp} from '../FeaturedAdApp';
//import {App} from './app';
import {DashBoard} from "../featuredad/dashboard";
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
//import {Abroad} from './abroad';
//import {Header} from './header';


@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [FeaturedAdApp, DashBoard, AccountSettings, IndividualAdBids, Stats],
    bootstrap: [FeaturedAdApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class FeaturedAdAppModule {}
