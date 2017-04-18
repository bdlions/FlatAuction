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
//@Component({
//    selector: 'data-content',
//    host: {
//        '(document:click)': 'handleClick($event)',
//    },
//    template: `
//        <div class="container" >
//            <div class="input-field col s12">
//              <input id="country" type="text" class="validate filter-input" [(ngModel)]=query (keyup)=filter($event)  (blur)=handleBlur()>
//              <label for="country">Country</label>
//            </div>
//            <div class="suggestions" *ngIf="filteredList.length > 0">
//                <ul *ngFor="let item of filteredList;let idx = index" >
//                 <li [class.complete-selected]="idx == selectedIdx">
//                        <a (click)="select(item)">{{item}}</a>
//                    </li>
//                </ul>
//            </div>
//        </div>
//    	`
//})
var AutoComplete = (function () {
    //    public query = '';
    //    public countries = ["Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium", "Bosnia & Herzegovina",
    //        "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Georgia",
    //        "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein",
    //        "Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands",
    //        "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia",
    //        "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom", "Vatican City"];
    //    public filteredList:any = [];
    //    public elementRef: ElementRef;
    //    selectedIdx: number;
    function AutoComplete(myElement) {
        this.elementRef = myElement;
        this.selectedIdx = -1;
    }
    return AutoComplete;
}());
AutoComplete = __decorate([
    core_1.Directive({ selector: '[myHighlight]' }),
    __metadata("design:paramtypes", [core_1.ElementRef])
], AutoComplete);
exports.AutoComplete = AutoComplete;
//# sourceMappingURL=autocomplete.js.map