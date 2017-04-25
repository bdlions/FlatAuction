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
import {Search} from '../common/search';
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {AutoComplete} from '../autocomplete';
import { Ng2CompleterModule } from "ng2-completer";

@NgModule({
    imports: [HttpModule, BrowserModule, FormsModule, Ng2CompleterModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    declarations: [Signup, NonMemberApp, Landing, Search, Productinfo, Bids, AutoComplete],
    bootstrap: [NonMemberApp],
    providers: [AuthGuard, {provide: LocationStrategy, useClass: HashLocationStrategy}]
})
export class NonMemberAppModule {}
