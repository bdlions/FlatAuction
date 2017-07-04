// Import our dependencies
import {Routes} from '@angular/router';
import {Login} from '../admin/login';

// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: Login},
    {path: '**', component: Login},
];
