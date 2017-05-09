// Import our dependencies
import {Routes} from '@angular/router';
import {DashBoard} from "../featuredad/dashboard";
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Faq} from "../featuredad/faq";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: AccountSettings},
    { path: 'accountsettings', component: AccountSettings },
    { path: 'individualadbids', component: IndividualAdBids },
    { path: 'stats', component: Stats },
    { path: 'ranking', component: Ranking },
    { path: 'faq', component: Faq },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: AccountSettings},
];
