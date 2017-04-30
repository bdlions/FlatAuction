import {Image} from "./Image";
import {Location} from "./Location";
import {General} from "./General";
import {Currency} from "./Currency";

export class Product {
    id:number;
    productId:string;
    location: Location;
    room: General;
    productsize: General;
    productType: General;    
    durations: Array<General>;
    area: Location;
    street:string;
    amenities: Array<General>;
    occupation: General;
    smoking:General;
    pet:General;
    basePrice: Currency;
    basePriceType: General;
    securityDeposit: Currency;
    availableFrom:string;
    minimumStay: General;
    maximumStay: General;
    title:string;
    description:string;
    displayFirstName:string;
    displayLastName:string;
    displayCellNo:string;
    dailyEmailAlert:boolean;
    instantEmailAlert:boolean;
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
    isFeaturedAdd:boolean;
    isDefaultBid:boolean;
    adBid: Currency;
}


