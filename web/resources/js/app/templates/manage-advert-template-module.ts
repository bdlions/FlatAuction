import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {routes} from '../routes/manage-advert-app-routes';
import {APP_BASE_HREF} from '@angular/common';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AuthGuard} from '../common/auth.guard';
//
import {ManageAdvertApp} from '../ManageAdvertApp';
//import {App} from './app';
import {SavedAds} from "../member/savedads";
import {MyAds} from "../member/myads";
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Faq} from "../featuredad/faq";
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
    declarations: [ManageAdvertApp, MyAds, Productinfo, Bids, SavedAds, AccountSettings, IndividualAdBids, Stats, Ranking, Faq],
    bootstrap: [ManageAdvertApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class ManageAdvertAppModule {}
