import {Image} from "./Image";

export class Product {
    id:number;
    title:string;
    description:string;
    price:number;
    time:number;
    img:string;
    type:number;
    location_type: string;
    search_string: string;
    images: Array<Image>;
}


