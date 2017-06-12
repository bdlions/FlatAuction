// Import our dependencies
import {Routes} from '@angular/router';
import {Inbox} from "../message/inbox";
import {Sent} from "../message/sent";
import {Saved} from "../message/saved";
import {Showmessage} from "../message/showmessage";


// Define which component should be loaded based on the current URL
export const routes: Routes = [
    { path: '', component: Inbox},
    { path: 'sent', component: Sent },
    { path: 'showmessage', component: Showmessage },
    { path: 'saved', component: Saved },
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: Inbox},
];
