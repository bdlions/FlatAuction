import {User} from "./User";
import {Currency} from "./Currency";
export class Bid {
    bidId:string;
    productId:string;
    time:string;
    amount:number;
    currency:Currency;
    user:User;
}