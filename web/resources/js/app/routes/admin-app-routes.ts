// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {DashBoard} from "../admin/dashboard";
import {Users} from "../admin/users";
import {Products} from "../admin/products";
import {Productinfo} from "../admin/product/productinfo";
import {Bids} from "../admin/product/bids";
import {Userinfo} from "../admin/user/userinfo";
import {Locations} from "../admin/locations";
import {Logout} from '../admin/logout';

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: DashBoard},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'home', component: DashBoard},
    {path: 'users', component: Users},
    {path: 'products', component: Products},
    {path: 'productinfo', component: Productinfo},
    {path: 'bids', component: Bids},
    {path: 'userinfo', component: Userinfo},
    {path: 'locations', component: Locations},
    {path: 'logout', component: Logout},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard},
];
