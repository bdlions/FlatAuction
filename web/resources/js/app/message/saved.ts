import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {Product} from '../dto/Product';
import {Message} from '../dto/Message';


@Component({
    selector: 'data-content',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/message/saved.html",
})
export class Saved implements OnInit, OnDestroy {
    private messages: Message[];
    //private productList: Product[];
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute) {        
        //this.productList = JSON.parse("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"} ]");
        //this.messages = JSON.parse("[{\"id\":\"1\",\"subject\":\"Hi There\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"2\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"2\",\"subject\":\"I need a flat\", \"to\":{\"useId\":\"3\", \"firstName\":\"User\", \"lastName\":\"3\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}}]},{\"id\":\"3\",\"subject\":\"I need a room\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"4\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"4\", \"firstName\":\"User\", \"lastName\":\"4\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"2\",\"subject\":\"I need a property\", \"to\":{\"useId\":\"5\", \"firstName\":\"User\", \"lastName\":\"5\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}}]},{\"id\":\"1\",\"subject\":\"Hi There\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"2\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"2\",\"subject\":\"I need a flat\", \"to\":{\"useId\":\"3\", \"firstName\":\"User\", \"lastName\":\"3\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}}]},{\"id\":\"3\",\"subject\":\"I need a room\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"4\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"4\", \"firstName\":\"User\", \"lastName\":\"4\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"2\",\"subject\":\"I need a property\", \"to\":{\"useId\":\"5\", \"firstName\":\"User\", \"lastName\":\"5\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"Is it available?\", \"time\":\"2017-04-26 8:02AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"3\", \"text\":\"Yes, available.\", \"time\":\"2017-04-26 8:03AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}}]}]");
        this.messages = JSON.parse("[{\"id\":\"1\",\"subject\":\"I need a flat.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 2 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"2\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 3 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 4 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"4\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 5 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"5\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 6 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"6\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 7 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"7\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 8 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"8\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 9 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"9\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 10 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"10\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}]");
        //console.log(this.productList);
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
    
    dashboard(event: Event) {
        event.preventDefault();
        this.router.navigate(['dashboard']);
    }
    
    inbox(event: Event) {
        event.preventDefault();
        this.router.navigate(['inbox']);
    }
    
    sent(event: Event) {
        event.preventDefault();
        this.router.navigate(['sent']);
    }
    
    saved(event: Event) {
        event.preventDefault();
        this.router.navigate(['saved']);
    }
}
