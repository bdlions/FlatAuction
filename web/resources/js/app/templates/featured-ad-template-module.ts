import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/featured-ad-app-routes';
import { DatepickerModule } from 'ngx-bootstrap';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {FeaturedAdApp} from '../FeaturedAdApp';
//import {App} from './app';
import {DashBoard} from "../featuredad/dashboard";
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Faq} from "../featuredad/faq";

@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule,
        DatepickerModule.forRoot(),
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [FeaturedAdApp, DashBoard, AccountSettings, IndividualAdBids, Stats, Ranking, Faq],
    bootstrap: [FeaturedAdApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class FeaturedAdAppModule {}
