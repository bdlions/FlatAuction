import {User} from "./User";
import {Currency} from "./Currency";
export class Bid {
    id:string;
    time:string;
    amount:number;
    currency:Currency;
    user:User;
}