import {User} from "./User";
import {Image} from "./Image";
import {Location} from "./Location";
import {ProductType} from "./ProductType";
import {ProductSize} from "./ProductSize";
import {ProductCategory} from "./ProductCategory";
import {Amenity} from "./Amenity";
import {Availability} from "./Availability";
import {Smoking} from "./Smoking";
import {Gender} from "./Gender";
import {Occupation} from "./Occupation";
import {Pet} from "./Pet";
import {Duration} from "./Duration";
import {Currency} from "./Currency";
import {Stay} from "./Stay";
export class Product {
    reasonCode:number;
    success: boolean;
    message:string;
    
    id:number;
    referenceId:string;
    productId:string;
    user:User;
    title:string;
    description:string;
    firstName:string;
    lastName:string;
    companyName:string;
    phone:string;
    img:string;
    images: Array<Image> = new Array<Image>();
    availableFrom : string;
    location: Location;
    productType: ProductType = new ProductType();
    productSize: ProductSize = new ProductSize;
    productCategory: ProductCategory = new ProductCategory();
    amenities: Array<Amenity>;
    availabilities: Array<Availability>;
    smoking: Smoking;
    gender: Gender;
    occupation: Occupation;
    pet: Pet;
    durations: Array<Duration>;
    basePrice: number;
    basePriceUnit: Currency;
    securityDeposit: number;
    securityDepositUnit: Currency;
    startDate: string;
    endDate: string;
    minStay: Stay;
    maxStay: Stay;
    isFeaturedAdd:boolean;
    isDefaultBid:boolean;
    adBid: Currency;
    adBidUnit: Currency;
    totalBids:number;
    
    //remove these fields after testing.
    area: Location;
    street:string;    
    //availableFrom:string;
    dailyEmailAlert:boolean;
    instantEmailAlert:boolean;
    price:number;
    time:number;
    type:number;
    location_type: string;
    search_string: string;    
    totalBidders:number;
    timeLeft:string;
}


