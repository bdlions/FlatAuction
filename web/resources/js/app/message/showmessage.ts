import {Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Message} from '../dto/Message';
import {MessageText} from '../dto/MessageText';
import {User} from '../dto/User';
import {Subscription} from 'rxjs';
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import { ModalDirective } from 'ngx-bootstrap';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/message/showmessage.html",
    providers: [WebAPIService]
})
export class Showmessage {
    private message: Message;
    private requestMessage: Message;
    private newMessage:Message;
    private newMessageText:MessageText;
    private newMessageBody:string;
    //private messages: Message[];
    private webAPIService: WebAPIService;
    private subscribe:Subscription;
    private id:number;
    
    @ViewChild('showMessageInfoModal') public showMessageInfoModal:ModalDirective;
    private modalMessage:string;
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.newMessage = new Message();
        this.newMessageText = new MessageText();
        this.newMessageBody = "";
        //this.message = new Message();
        //this.messages = JSON.parse("[{\"id\":\"1\",\"subject\":\"I need a flat.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"2\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 2 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"2\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 3 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"3\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 4 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"4\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 5 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"5\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 6 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"6\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 7 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"7\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 8 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"8\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 9 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"9\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}, {\"id\":\"1\",\"subject\":\"I need 10 flats.\", \"to\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"10\"}, \"messageList\":[{\"id\":\"1\", \"text\":\"How are you?\", \"time\":\"2017-04-26 8:00AM\", \"user\":{\"useId\":\"2\", \"firstName\":\"User\", \"lastName\":\"1\"}}, {\"id\":\"2\", \"text\":\"I am good\", \"time\":\"2017-04-26 8:01AM\", \"user\":{\"useId\":\"1\", \"firstName\":\"User\", \"lastName\":\"1\"}}]}]");
        //this.message = this.messages[0];
        
        setInterval(() => { this.showMessageInfoModal.hide(); }, 1000 * 5);
    }
    
    public hideChildModal(): void {
        this.showMessageInfoModal.hide();
        this.modalMessage = "";
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            if(params['id'] > 0)
            {
                this.message = new Message();
                this.id = params['id']; 
                this.requestMessage = new Message();
                this.requestMessage.id = this.id;
                let requestBody: string = JSON.stringify(this.requestMessage);
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_MESSAGE_INFO), requestBody).then(result => {
                    this.message = result;
                });
            }            
        });
    }
    
    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    sendmessage(event: Event) {
        //check whether message text is empty or not. if empty then show an error message.
        if (this.newMessageBody == null || this.newMessageBody.length == 0)
        {
            this.modalMessage = "Please add message text.";
            this.showMessageInfoModal.show();
            return;
        }
        this.newMessageText = new MessageText();
        this.newMessageText.body = this.newMessageBody;
        this.newMessageText.messageId = this.message.id;
        this.newMessage = this.message;
        this.newMessage.messageTextList = new Array<MessageText>();
        this.newMessage.messageTextList[0] = this.newMessageText;
        let requestBody: string = JSON.stringify(this.newMessage);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_MESSAGE_TEXT), requestBody).then(result => {
            this.message = result;
            //if success the append message text at bottom of message list
            this.newMessage = new Message();
            this.newMessageText = new MessageText();
            this.newMessageBody = "";
            
            let response  = result; 
            this.modalMessage = response.message;
            this.showMessageInfoModal.show();
        });
    }
    
    inbox(event: Event) {
        event.preventDefault();
        this.router.navigate(['inbox']);
    }
    
    basicsearch(event: Event) {
        event.preventDefault();
        this.router.navigate(['basicsearch']);
    }
    
    saved(event: Event) {
        event.preventDefault();
        this.router.navigate(['saved']);
    }
}
