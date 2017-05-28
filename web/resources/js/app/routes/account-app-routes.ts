// Import our dependencies
import {Routes} from '@angular/router';
import {Notifications} from "../account/notifications";


// Define which component should be loaded based on the current URL
export const routes: Routes = [
    { path: '', component: Notifications},
    { path: 'notifications', component: Notifications},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Notifications},
];
