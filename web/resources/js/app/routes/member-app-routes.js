"use strict";
var auth_guard_1 = require("../common/auth.guard");
var dashboard_1 = require("../member/dashboard");
var savedads_1 = require("../member/savedads");
var myads_1 = require("../member/myads");
var messages_1 = require("../member/messages");
// Define which component should be loaded based on the current URL
exports.routes = [
    { path: '', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    { path: 'savedads', component: savedads_1.SavedAds, canActivate: [auth_guard_1.AuthGuard] },
    { path: 'myads', component: myads_1.MyAds, canActivate: [auth_guard_1.AuthGuard] },
    { path: 'messages', component: messages_1.Messages, canActivate: [auth_guard_1.AuthGuard] },
    { path: 'home', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    { path: '**', component: dashboard_1.DashBoard, canActivate: [auth_guard_1.AuthGuard] },
];
//# sourceMappingURL=member-app-routes.js.map