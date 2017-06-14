import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Message} from '../dto/Message';
import {Subscription} from 'rxjs';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/message/showmessage.html",
    providers: [WebAPIService]
})
export class Showmessage {
    private message: Message;
    private messages: Message[];
    private webAPIService: WebAPIService;
    private subscribe:Subscription;
    private id:number;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.message = new Message();
        this.messages = JSON.parse("[{\"id\":\"1\",\"subject\":\"I need a flat.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"2\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 2 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"2\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 3 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 4 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"4\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 5 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"5\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 6 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"6\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 7 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"7\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 8 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"8\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 9 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"9\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 10 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"10\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}]");
        this.message = this.messages[0];
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id']; 
        });
    }
    
    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
}
