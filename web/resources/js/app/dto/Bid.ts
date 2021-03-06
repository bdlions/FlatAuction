import {User} from "./User";
import {Product} from "./Product";
import {Currency} from "./Currency";
import {CurrencyUnit} from "./CurrencyUnit";
export class Bid {
    id: number;
    referenceId:string;
    user:User;
    product: Product;
    bidTime:string;
    price:number;
    currency:Currency;
    currencyUnit:CurrencyUnit;
}