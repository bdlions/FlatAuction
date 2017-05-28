// Import our dependencies
import {Routes} from '@angular/router';
import {BasicSearch} from "../common/basicsearch";
import {AdvancedSearch} from "../common/advancedsearch";


// Define which component should be loaded based on the current URL
export const routes: Routes = [
    { path: '', component: BasicSearch},
    { path: 'advancedsearch', component: AdvancedSearch },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: BasicSearch},
];
