// Import our dependencies
import {Routes} from '@angular/router';
import {AuthGuard} from '../common/auth.guard';
import {MemberApp} from "../MemberApp";
import {DashBoard} from "../member/dashboard";
import {MyHome} from "../home/myhome";
import {MyProduct} from "../manageproduct/myproduct";
import {MyAds} from "../member/myads";
import {SavedAds} from "../member/savedads";
import {Productinfo} from '../common/productinfo';
import {Bids} from '../common/bids';
import {AccountSettings} from "../featuredad/accountsettings";
import {IndividualAdBids} from "../featuredad/individualadbids";
import {Stats} from "../featuredad/stats";
import {Ranking} from "../featuredad/ranking";
import {Faq} from "../featuredad/faq";
//import {Messages} from "../member/messages";
import {Inbox} from "../message/inbox";
import {Sent} from "../message/sent";
import {Saved} from "../message/saved";
import {Showmessage} from "../message/showmessage";
import {Notifications} from "../account/notifications";
import {MyProfile} from "../profile/myprofile";
import {EditProfile} from "../profile/editprofile";
import {UploadImg} from "../profile/uploadimg";
import {UploadDocument} from "../profile/uploaddocument";
import {BasicSearch} from "../common/basicsearch";
import {AdvancedSearch} from "../common/advancedsearch";
import {AppHeader} from '../member/header';
import {AppFooter} from '../member/footer';
import {Terms} from '../common/terms';
import {Privacypolicy} from '../common/privacypolicy';
import {Contactus} from '../common/contactus';
import {Logout} from '../common/logout';


// Define which component should be loaded based on the current URL
export const routes: Routes = [
    {path: '', component: DashBoard},
    {path: 'dashboard', component: DashBoard},
    //    {path: 'signup', component: Signup},
    //  { path: 'signup', component: Signup },
    {path: 'myhome', component: MyHome},
    {path: 'myproduct', component: MyProduct},
    {path: 'myads', component: MyAds},
    {path: 'savedads', component: SavedAds},  
    { path: 'productinfo', component: Productinfo},
    { path: 'bids', component: Bids},
    { path: 'accountsettings', component: AccountSettings },
    { path: 'individualadbids', component: IndividualAdBids },
    { path: 'stats', component: Stats },
    { path: 'ranking', component: Ranking },
    { path: 'faq', component: Faq },  
    //{path: 'messages', component: Messages},
    { path: 'inbox', component: Inbox },
    { path: 'sent', component: Sent },    
    { path: 'saved', component: Saved },
    { path: 'showmessage', component: Showmessage },
    { path: 'notifications', component: Notifications},
    {path: 'myprofile', component: MyProfile},
    {path: 'editprofile', component: EditProfile},
    {path: 'uploadimg', component: UploadImg},
    {path: 'uploaddocument', component: UploadDocument},
    { path: 'basicsearch', component: BasicSearch },
    { path: 'advancedsearch', component: AdvancedSearch },
    {path: 'terms', component: Terms},
    {path: 'privacypolicy', component: Privacypolicy},
    {path: 'contactus', component: Contactus},
    {path: 'logout', component: Logout},
    //{path: 'home', component: DashBoard, canActivate: [AuthGuard]},
    //  { path: 'abroad',   component: Abroad, canActivate: [AuthGuard] },
    {path: '**', component: DashBoard},
    {path: '', component: AppHeader},
    {path: '', component: AppFooter},
];
