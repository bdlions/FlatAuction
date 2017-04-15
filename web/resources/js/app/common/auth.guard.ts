import {Injectable} from '@angular/core';
import {Router, CanActivate} from '@angular/router';
import {tokenNotExpired} from 'angular2-jwt';


@Injectable()
export class AuthGuard implements CanActivate {
    constructor(private router: Router) {}

    canActivate() {

        // Check to see if a user has a valid JWT
        if (localStorage.getItem('username')) {
            // If they do, return true and allow the user to load the home component
            console.log(localStorage.getItem("username"));
            return true;
        }

        console.log("no user exists");
        // If not, they redirect them to the login page
//        this.router.navigate(['/login']);
        window.location.href = "non-member.jsp";
        return false;
    }
}