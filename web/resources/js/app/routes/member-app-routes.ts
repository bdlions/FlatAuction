// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {MemberApp} from "../MemberApp";
import {DashBoard} from "../member/dashboard";
import {SavedAds} from "../member/savedads";
import {MyAds} from "../member/myads";
import {Messages} from "../member/messages";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: DashBoard, canActivate: [AuthGuard]},
    {path: 'dashboard', component: DashBoard, canActivate: [AuthGuard]},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'savedads', component: SavedAds, canActivate: [AuthGuard]},
    {path: 'myads', component: MyAds, canActivate: [AuthGuard]},
    {path: 'messages', component: Messages, canActivate: [AuthGuard]},
    //{path: 'home', component: DashBoard, canActivate: [AuthGuard]},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard, canActivate: [AuthGuard] },
];
