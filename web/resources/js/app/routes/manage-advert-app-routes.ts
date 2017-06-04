// Import our dependencies
import {Routes} from '@angular/router';
import {SavedAds} from "../member/savedads";
import {MyAds} from "../member/myads";
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Faq} from "../featuredad/faq";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    { path: '', component: MyAds},
    { path: 'productinfo', component: Productinfo},
    {path: 'bids', component: Bids},
    { path: 'savedads', component: SavedAds},
    { path: 'accountsettings', component: AccountSettings },
    { path: 'individualadbids', component: IndividualAdBids },
    { path: 'stats', component: Stats },
    { path: 'ranking', component: Ranking },
    { path: 'faq', component: Faq },
    //  { path: 'signup', component: Signup },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: MyAds},
];
