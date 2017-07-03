"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var http_1 = require("@angular/http");
var web_api_service_1 = require("./../webservice/web-api-service");
var Login = (function () {
    function Login(router, http, webAPIService) {
        this.router = router;
        this.http = http;
        this.webAPIService = webAPIService;
    }
    return Login;
}());
Login = __decorate([
    core_1.Component({
        templateUrl: window.SUB_DIRECTORY + "/html_components/public/login.html",
        providers: [web_api_service_1.WebAPIService]
    }),
    __metadata("design:paramtypes", [router_1.Router, http_1.Http, web_api_service_1.WebAPIService])
], Login);
exports.Login = Login;
//# sourceMappingURL=login.js.map