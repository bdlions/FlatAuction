"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var router_1 = require("@angular/router");
var http_1 = require("@angular/http");
var forms_1 = require("@angular/forms");
var member_app_routes_1 = require("../routes/member-app-routes");
var common_1 = require("@angular/common");
var auth_guard_1 = require("../common/auth.guard");
//
var MemberApp_1 = require("../MemberApp");
//import {App} from './app';
var dashboard_1 = require("../member/dashboard");
var savedads_1 = require("../member/savedads");
var myads_1 = require("../member/myads");
var messages_1 = require("../member/messages");
//import {Abroad} from './abroad';
//import {Header} from './header';
var MemberAppModule = (function () {
    function MemberAppModule() {
    }
    return MemberAppModule;
}());
MemberAppModule = __decorate([
    core_1.NgModule({
        imports: [http_1.HttpModule, platform_browser_1.BrowserModule, forms_1.FormsModule,
            router_1.RouterModule.forRoot(member_app_routes_1.routes, {
                useHash: false
            })
        ],
        declarations: [MemberApp_1.MemberApp, dashboard_1.DashBoard, savedads_1.SavedAds, myads_1.MyAds, messages_1.Messages],
        bootstrap: [MemberApp_1.MemberApp],
        providers: [auth_guard_1.AuthGuard, { provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }]
    })
], MemberAppModule);
exports.MemberAppModule = MemberAppModule;
//# sourceMappingURL=member-template-module.js.map