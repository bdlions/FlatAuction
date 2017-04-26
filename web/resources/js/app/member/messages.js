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
var Messages = (function () {
    function Messages(router, route) {
        this.router = router;
        this.route = route;
        this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        this.inbox = JSON.parse("[{\"id\":\"1\",\"subject\":\"Hi There\", \"to\":{\"useId\":\"1\", \"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"Almgir\", \"lastName\":\"Kabir\"}}]}, {\"id\":\"2\",\"subject\":\"I need a flat\", \"to\":{\"useId\":\"3\", \"firstName\":\"Nazmul\", \"lastName\":\"Islam\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"Nazmul\", \"lastName\":\"Islam\"}}]}]");
        console.log(this.productList);
    }
    Messages.prototype.selectProduct = function (event, id) {
        this.router.navigate(['productinfo', { id: this.id }]);
    };
    Messages.prototype.ngOnInit = function () {
        var _this = this;
        this.subscribe = this.route.params.subscribe(function (params) {
            _this.id = params['id'];
            console.log(_this.id);
        });
    };
    Messages.prototype.ngOnDestroy = function () {
        this.subscribe.unsubscribe();
    };
    return Messages;
}());
Messages = __decorate([
    core_1.Component({
        selector: 'data-content',
        templateUrl: window.SUB_DIRECTORY + "/html_components/member/messages.html",
    }),
    __metadata("design:paramtypes", [router_1.Router, router_1.ActivatedRoute])
], Messages);
exports.Messages = Messages;
//# sourceMappingURL=messages.js.map