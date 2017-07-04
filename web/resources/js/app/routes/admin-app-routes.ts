// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {Login} from '../admin/login';
import {DashBoard} from "../admin/dashboard";
import {Users} from "../admin/users";
import {Products} from "../admin/products";
import {Locations} from "../admin/locations";

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: Login},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'home', component: DashBoard},
    {path: 'users', component: Users},
    {path: 'products', component: Products},
    {path: 'locations', component: Locations},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Login},
];
