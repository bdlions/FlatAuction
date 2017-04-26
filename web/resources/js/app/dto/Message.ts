import {User} from "./User";
import {MessageText} from "./MessageText";

export class Message {
    id:string;
    from: User;
    to: User;
    subject:string;
    messageList: Array<MessageText>;
}