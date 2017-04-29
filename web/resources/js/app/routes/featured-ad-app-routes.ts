// Import our dependencies
import {Routes} from '@angular/router';
import {DashBoard} from "../featuredad/dashboard";
import {Stats} from "../featuredad/stats";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: DashBoard},
    { path: 'stats', component: Stats },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard},
];
