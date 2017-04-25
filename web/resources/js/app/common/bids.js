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
var Product_1 = require("../dto/Product");
var Bids = (function () {
    function Bids(router) {
        this.router = router;
        this.product = new Product_1.Product();
        this.product.id = 1;
        this.product.title = "Fun at the Bowling Alley";
        this.product.description = "Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR.";
        this.product.price = 100;
        this.product.time = 1000;
        this.product.img = "a.jpg";
        this.product.type = 1;
        this.product.location_type = "location1";
        this.product.images = JSON.parse("[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}]");
        this.product.totalBidders = 10;
        this.product.totalBids = 36;
        this.product.timeLeft = "1 day 13 hours 30 mins";
        this.bidList = JSON.parse("[{\"id\":\"1\",\"time\":\"21 Apr 2017 9:38:35AM\",\"amount\":\"1000\", \"currency\":{\"id\":\"1\", \"title\":\"$\"}, \"user\":{\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"id\":\"2\",\"time\":\"20 Apr 2017 9:38:35AM\",\"amount\":\"2000\", \"currency\":{\"id\":\"1\", \"title\":\"$\"}, \"user\":{\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}}]");
        console.log(this.bidList);
    }
    Bids.prototype.ngOnInit = function () {
        var _this = this;
        this.subscribe = this.router.params.subscribe(function (params) {
            _this.id = params['id'];
            console.log(_this.id);
        });
    };
    Bids.prototype.ngOnDestroy = function () {
        this.subscribe.unsubscribe();
    };
    return Bids;
}());
Bids = __decorate([
    core_1.Component({
        selector: 'data-content',
        templateUrl: "./../../../../html_components/public/bid.html",
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute])
], Bids);
exports.Bids = Bids;
//# sourceMappingURL=bids.js.map