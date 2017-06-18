import {User} from "./User";
import {Product} from "./Product";
import {MessageText} from "./MessageText";

export class Message {
    id:number;
    from: User;
    to: User;
    product: Product;
    subject:string;
    messageTextList: Array<MessageText>;
}