import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';
import {Message} from '../dto/Message';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/messages.html",
})
export class Messages implements OnInit, OnDestroy {
    private inbox: Message[];
    private productList: Product[];
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute) {        
        this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        this.inbox = JSON.parse("[{\"id\":\"1\",\"subject\":\"Hi There\", \"to\":{\"useId\":\"1\", \"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"Almgir\", \"lastName\":\"Kabir\"}}]}, {\"id\":\"2\",\"subject\":\"I need a flat\", \"to\":{\"useId\":\"3\", \"firstName\":\"Nazmul\", \"lastName\":\"Islam\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"Nazmul\", \"lastName\":\"Islam\"}}]}]");
        console.log(this.productList);
    }
    
    
    public selectProduct(event: Event, id: number){
        this.router.navigate(['productinfo', {id: this.id }]);
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
            console.log(this.id);
            
            
        }); 
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}
