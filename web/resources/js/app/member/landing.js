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
var Observable_1 = require("rxjs/Observable");
require("rxjs/Rx");
var ng2_completer_1 = require("ng2-completer");
var Landing = (function () {
    function Landing(router, completerService) {
        this.router = router;
        this.completerService = completerService;
        this.productList = JSON.parse("[{\"location_type\":\"area\",\"search_string\":\"London\"}, {\"location_type\":\"area\",\"search_string\":\"London 123\"}]");
        this.featuredProductList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}, {\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}]");
        var timedRes = Observable_1.Observable.from([this.productList]).delay(2000);
        this.dataService = completerService.local(timedRes, 'search_string', 'search_string');
    }
    Landing.prototype.login = function (event, username, password) {
        event.preventDefault();
        localStorage.setItem("username", username);
        window.location.replace("/");
        window.location.href = "member.jsp";
    };
    Landing.prototype.signup = function (event) {
        event.preventDefault();
        this.router.navigate(['signup']);
    };
    Landing.prototype.search = function (event, id) {
        event.preventDefault();
        this.router.navigate(['search', { id: id }]);
    };
    return Landing;
}());
Landing = __decorate([
    core_1.Component({
        selector: 'content',
        templateUrl: "./../../../../html_components/public/landing.html",
    }),
    __metadata("design:paramtypes", [router_1.Router, ng2_completer_1.CompleterService])
], Landing);
exports.Landing = Landing;
//# sourceMappingURL=landing.js.map