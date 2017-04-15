// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {MemberApp} from "../MemberApp";
import {DashBoard} from "../member/dashboard";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: DashBoard, canActivate: [AuthGuard]},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'home', component: DashBoard, canActivate: [AuthGuard]},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard, canActivate: [AuthGuard] },
];
