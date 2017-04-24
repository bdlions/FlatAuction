"use strict";
//import { Home } from './home';
//import { Login } from './login';
var signup_1 = require("../member/signup");
var landing_1 = require("../member/landing");
var search_1 = require("../common/search");
var productinfo_1 = require("../common/productinfo");
var bids_1 = require("../common/bids");
//import {Angular2Autocomplete} from '../autocomplete/autocomplete-example';
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: landing_1.Landing },
    { path: 'signup', component: signup_1.Signup },
    { path: 'search', component: search_1.Search },
    { path: 'productinfo', component: productinfo_1.Productinfo },
    { path: 'bids', component: bids_1.Bids },
    //    {path: 'complete', component: AutoComplete},
    //  { path: 'home',   component: Home, canActivate: [AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: landing_1.Landing },
];
//# sourceMappingURL=non-member-app-routes.js.map