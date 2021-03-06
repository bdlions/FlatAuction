// Import our dependencies
import {Routes} from '@angular/router';
//import { Home } from './home';
//import { Login } from './login';
import {Login} from '../nonmember/login';
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
import {AppHeader} from '../common/header';
import {AppFooter} from '../common/footer';
import {Terms} from '../common/terms';
import {Privacypolicy} from '../common/privacypolicy';
import {Contactus} from '../common/contactus';
import {Aboutus} from '../common/aboutus';
import {Faq} from '../common/faq';
//import {AutoComplete} from '../autocomplete';
//import {Angular2Autocomplete} from '../autocomplete/autocomplete-example';

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: Landing},
    {path: 'landing', component: Landing},
    {path: 'login', component: Login},
    {path: 'signup', component: Signup},
    {path: 'basicsearch', component: BasicSearch},
    {path: 'advancedsearch', component: AdvancedSearch},
    {path: 'search', component: Search},
    {path: 'productinfo', component: Productinfo},
    {path: 'bids', component: Bids},
    {path: 'terms', component: Terms},
    {path: 'privacypolicy', component: Privacypolicy},
    {path: 'contactus', component: Contactus},
    {path: 'aboutus', component: Aboutus},
    {path: 'faq', component: Faq},
//    {path: 'complete', component: AutoComplete},
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Landing},
    {path: '', component: AppHeader},
    {path: '', component: AppFooter},
];
