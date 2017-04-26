import {Image} from "./Image";

export class Product {
    id:number;
    productId:string;
    title:string;
    description:string;
    price:number;
    time:number;
    img:string;
    type:number;
    location_type: string;
    search_string: string;
    images: Array<Image>;
    totalBidders:number;
    totalBids:number;
    timeLeft:string;
    startDate:string;
    endDate:string;
}


