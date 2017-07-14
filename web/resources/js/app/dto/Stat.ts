import {Currency} from "./Currency";
import {Product} from "./Product";
export class Stat {
    product: Product;
    date:string;
    clicks:string;
    impressions:string;
    ctr:string;
    cost:number;
    costUnit:Currency;
}