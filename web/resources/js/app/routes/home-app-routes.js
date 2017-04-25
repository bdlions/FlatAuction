"use strict";
var dashboard_1 = require("../home/dashboard");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: dashboard_1.DashBoard },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: dashboard_1.DashBoard },
];
//# sourceMappingURL=home-app-routes.js.map