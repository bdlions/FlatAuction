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
var Search = (function () {
    function Search(router) {
        this.router = router;
        this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":{\"img\":\"a.jpg\"}, \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":{\"img\":\"a.jpg\", \"img\":\"b.jpg\"}, \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":{\"img\":\"a.jpg\", \"img\":\"b.jpg\", \"img\":\"c.jpg\"}, \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":{\"img\":\"a.jpg\", \"img\":\"b.jpg\", \"img\":\"c.jpg\", \"img\":\"d.jpg\"}, \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
    }
    Search.prototype.ngOnInit = function () {
        var _this = this;
        this.subscribe = this.router.params.subscribe(function (params) {
            _this.id = params['id'];
            console.log(_this.id);
        });
    };
    Search.prototype.ngOnDestroy = function () {
        this.subscribe.unsubscribe();
    };
    return Search;
}());
Search = __decorate([
    core_1.Component({
        selector: 'data-content',
        templateUrl: "./../../../../html_components/public/search.html",
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute])
], Search);
exports.Search = Search;
//# sourceMappingURL=search.js.map