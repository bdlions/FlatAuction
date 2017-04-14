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
var non_member_app_routes_1 = require("../routes/non-member-app-routes");
var common_1 = require("@angular/common");
var auth_guard_1 = require("../common/auth.guard");
var NonMemberApp_1 = require("../NonMemberApp");
var signup_1 = require("../member/signup");
var landing_1 = require("../member/landing");
var NonMemberAppModule = (function () {
    function NonMemberAppModule() {
    }
    return NonMemberAppModule;
}());
NonMemberAppModule = __decorate([
    core_1.NgModule({
        imports: [http_1.HttpModule, platform_browser_1.BrowserModule, forms_1.FormsModule,
            router_1.RouterModule.forRoot(non_member_app_routes_1.routes, {
                useHash: false
            })
        ],
        declarations: [signup_1.Signup, NonMemberApp_1.NonMemberApp, landing_1.Landing],
        bootstrap: [NonMemberApp_1.NonMemberApp],
        providers: [auth_guard_1.AuthGuard, { provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }]
    })
], NonMemberAppModule);
exports.NonMemberAppModule = NonMemberAppModule;
//# sourceMappingURL=non-member-template-module.js.map