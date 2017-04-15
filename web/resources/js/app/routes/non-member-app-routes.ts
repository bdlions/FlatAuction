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

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: Landing},
    //  { path: 'login',  component: Signup },
    {path: 'signup', component: Signup},
    {path: 'search', component: Search},
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Landing},
];
