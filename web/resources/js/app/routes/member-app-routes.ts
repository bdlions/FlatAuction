// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {MemberApp} from "../MemberApp";
import {Signup} from "../member/signup";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
//    {path: '', component: MemberApp},
//    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    //  { path: '**',     component: Login },
];
