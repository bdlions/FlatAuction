"use strict";
//import { Home } from './home';
//import { Login } from './login';
var signup_1 = require("../member/signup");
var landing_1 = require("../member/landing");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: landing_1.Landing },
    //  { path: 'login',  component: Signup },
    { path: 'signup', component: signup_1.Signup },
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: landing_1.Landing },
];
//# sourceMappingURL=non-member-app-routes.js.map