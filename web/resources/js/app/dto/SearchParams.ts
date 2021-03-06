import {ProductType} from "./ProductType";
import {Location} from "./Location";
import {ProductSize} from "./ProductSize";
import {Occupation} from "./Occupation";
import {Pet} from "./Pet";
import {Availability} from "./Availability";
export class SearchParams {
    referenceId:string;
    productType:ProductType;
    location: Location;
    productSize: ProductSize;
    occupation: Occupation;
    pet: Pet;
    minPrice: number;
    maxPrice: number;
    availability: Availability;
}