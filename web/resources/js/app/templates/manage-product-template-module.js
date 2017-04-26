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
var manage_product_app_routes_1 = require("../routes/manage-product-app-routes");
var common_1 = require("@angular/common");
var auth_guard_1 = require("../common/auth.guard");
//
var ManageProductApp_1 = require("../ManageProductApp");
//import {App} from './app';
var dashboard_1 = require("../manageproduct/dashboard");
//import {Abroad} from './abroad';
//import {Header} from './header';
var ManageProductAppModule = (function () {
    function ManageProductAppModule() {
    }
    return ManageProductAppModule;
}());
ManageProductAppModule = __decorate([
    core_1.NgModule({
        imports: [http_1.HttpModule, platform_browser_1.BrowserModule, forms_1.FormsModule,
            router_1.RouterModule.forRoot(manage_product_app_routes_1.routes, {
                useHash: false
            })
        ],
        declarations: [ManageProductApp_1.ManageProductApp, dashboard_1.DashBoard],
        bootstrap: [ManageProductApp_1.ManageProductApp],
        providers: [auth_guard_1.AuthGuard, { provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }]
    })
], ManageProductAppModule);
exports.ManageProductAppModule = ManageProductAppModule;
//# sourceMappingURL=manage-product-template-module.js.map