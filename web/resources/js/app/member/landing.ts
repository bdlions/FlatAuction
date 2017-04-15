import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {Product} from '../dto/Product';

@Component({
    selector: 'content',
    templateUrl: "./../../../../html_components/public/landing.html",
})
export class Landing {
    private productList: Product[];
    private featuredProductList: Product[];

    constructor(public router: Router) {
        this.productList = JSON.parse("[{\"location_type\":\"area\",\"search_string\":\"London\"}, {\"location_type\":\"area\",\"search_string\":\"London 123\"}]");
        this.featuredProductList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley\", \"price\":\"100\", \"time\":\"1010\", \"img\":\"a.jpg\", \"type\":\"1\"},{\"id\":\"2\",\"title\":\"iPhone 7\", \"price\":\"1000\", \"time\":\"2020\", \"img\":\"b.jpg\", \"type\":\"2\"}]");
    }

    login(event: Event, username: string, password: string) {
        event.preventDefault();
        localStorage.setItem("username", username);
        window.location.replace("/");
        window.location.href = "member.jsp";
    }

    signup(event: Event) {
        event.preventDefault();
        this.router.navigate(['signup']);
    }
    search(event: Event, id: number) {
        event.preventDefault();
        this.router.navigate(['search', {id: id}]);
    }
}



