"use strict";
var dashboard_1 = require("../admin/dashboard");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: dashboard_1.DashBoard },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    { path: 'home', component: dashboard_1.DashBoard },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: dashboard_1.DashBoard },
];
//# sourceMappingURL=admin-app-routes.js.map