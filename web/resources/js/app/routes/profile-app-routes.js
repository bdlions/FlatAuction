"use strict";
var dashboard_1 = require("../profile/dashboard");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: dashboard_1.DashBoard },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: dashboard_1.DashBoard },
];
//# sourceMappingURL=profile-app-routes.js.map