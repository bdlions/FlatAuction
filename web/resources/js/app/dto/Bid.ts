import {User} from "./User";
import {Product} from "./Product";
import {Currency} from "./Currency";
export class Bid {
    id: number;
    bidId:string;
    user:User;
    product: Product;
    bidTime:string;
    bidAmount:number;
    bidAmountUnit:Currency;
    
}