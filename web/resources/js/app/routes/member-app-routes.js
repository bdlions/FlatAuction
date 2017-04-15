"use strict";
var auth_guard_1 = require("../common/auth.guard");
var dashboard_1 = require("../member/dashboard");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    { path: 'home', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
];
//# sourceMappingURL=member-app-routes.js.map