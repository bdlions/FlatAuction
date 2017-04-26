// Import our dependencies
import {Routes} from '@angular/router';
//import { Home } from './home';
//import { Login } from './login';
import {Signup} from '../member/signup';
import {Landing} from '../member/landing';
//import { Home } from './home';
//import { Abroad } from './abroad';
import {AuthGuard} from '../common/auth.guard';
import {Search} from '../common/search';
import {BasicSearch} from '../common/basicsearch';
import {AdvancedSearch} from '../common/advancedsearch';
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
//import {AutoComplete} from '../autocomplete';
//import {Angular2Autocomplete} from '../autocomplete/autocomplete-example';

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: Landing},
    {path: 'signup', component: Signup},
    {path: 'basicsearch', component: BasicSearch},
    {path: 'advancedsearch', component: AdvancedSearch},
    {path: 'search', component: Search},
    {path: 'productinfo', component: Productinfo},
    {path: 'bids', component: Bids},
//    {path: 'complete', component: AutoComplete},
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Landing},
];
