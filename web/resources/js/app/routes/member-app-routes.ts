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
    {path: '', component: DashBoard},
    {path: 'dashboard', component: DashBoard},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'savedads', component: SavedAds},
    {path: 'myads', component: MyAds},
    {path: 'messages', component: Messages},
    //{path: 'home', component: DashBoard, canActivate: [AuthGuard]},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard},
];
