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
var PacketHeaderFactory_1 = require("./../webservice/PacketHeaderFactory");
var ACTION_1 = require("./../webservice/ACTION");
var ngx_bootstrap_1 = require("ngx-bootstrap");
var Login = (function () {
    function Login(router, http, webAPIService) {
        this.router = router;
        this.http = http;
        this.webAPIService = webAPIService;
        var username = localStorage.getItem("username");
        var password = localStorage.getItem("password");
        if (username != null && username != "" && password != null && password != "") {
            this.loginUser(username, password);
        }
    }
    Login.prototype.showChildModal = function () {
        this.childModal.show();
    };
    Login.prototype.hideChildModal = function () {
        this.childModal.hide();
    };
    Login.prototype.login = function (event, username, password) {
        if (username == null || username == "") {
            this.errorMsg = "Email is required.";
            return;
        }
        if (password == null || password == "") {
            this.errorMsg = "Password is required.";
        }
        event.preventDefault();
        this.loginUser(username, password);
    };
    Login.prototype.loginUser = function (username, password) {
        var _this = this;
        var requestBody = "{\"userName\": \"" + username + "\", \"password\": \"" + password + "\"}";
        this.webAPIService.getResponse(PacketHeaderFactory_1.PacketHeaderFactory.getHeader(ACTION_1.ACTION.SIGN_IN), requestBody).then(function (result) {
            var response = result;
            if (response.success) {
                var signInResponse = result;
                if (signInResponse.sessionId != null && signInResponse.sessionId != "") {
                    localStorage.setItem("username", username);
                    localStorage.setItem("password", password);
                    localStorage.setItem("sessionId", signInResponse.sessionId);
                    window.location.replace("/");
                    window.location.href = "member.jsp";
                }
                else {
                    localStorage.removeItem("sessionId");
                    _this.errorMsg = "Invalid session.";
                }
            }
            else {
                _this.errorMsg = response.message;
            }
        });
    };
    return Login;
}());
__decorate([
    core_1.ViewChild('childModal'),
    __metadata("design:type", ngx_bootstrap_1.ModalDirective)
], Login.prototype, "childModal", void 0);
Login = __decorate([
    core_1.Component({
        templateUrl: window.SUB_DIRECTORY + "/html_components/public/login.html",
        providers: [web_api_service_1.WebAPIService]
    }),
    __metadata("design:paramtypes", [router_1.Router, http_1.Http, web_api_service_1.WebAPIService])
], Login);
exports.Login = Login;
//# sourceMappingURL=login.js.map