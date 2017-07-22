import {Component} from '@angular/core';
import { DatePipe } from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs';
import {User} from '../dto/User'
import {Product} from '../dto/Product'
import {Image} from '../dto/Image'
import {General} from '../dto/General'
import {ProductType} from '../dto/ProductType'
import {ProductSize} from '../dto/ProductSize'
import {ProductCategory} from '../dto/ProductCategory'
import {Amenity} from '../dto/Amenity'
import {Location} from '../dto/Location'
import {Availability} from '../dto/Availability'
import {Stay} from '../dto/Stay'
import {Smoking} from '../dto/Smoking'
import {Occupation} from '../dto/Occupation'
import {Pet} from '../dto/Pet'
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import { FileUploader } from 'ng2-file-upload';

const URL = window.SUB_DIRECTORY + '/FileUploadServlet';

@Component({
    selector: 'data-content1ddd',
    templateUrl: window.SUB_DIRECTORY +"/html_components/member/manageproduct/index.html",
    providers: [WebAPIService, DatePipe]
})
export class MyProduct {
    private datePipe: DatePipe;
    private subscribe:Subscription;
    private id:number;
    private requestProduct: Product;
    private responseProduct: Product;
    public uploader:FileUploader = new FileUploader({url: URL});
    private webAPIService: WebAPIService;
    private product: Product;
    //private images: Image[];
    private productTypeList: ProductType[];
    private productSizeList: ProductSize[];    
    private productCategoryList: ProductCategory[];
    private amenityList: Amenity[];
    private amenities: Amenity[];
    private tempAmenities: Amenity[];
    //private selectedProductType: ProductType;
    //private selectedProductSize: ProductSize;
    //private selectedProductCategory: ProductCategory; 
    private locationList: Location[]; 
    private availabilityList: Availability[];  
    private availabilities:Availability[];  
    private tempAvailabilities:Availability[];  
    private minStayList: Stay[];
    private maxStayList: Stay[];
    private smokingList: Smoking[];
    private occupationList: Occupation[];    
    private petList: Pet[];
    //private roomList: General[];
    
    //private durationList: General[];    
    private showDatePicker: boolean = false;
    public availableFrom: Date = new Date();
    public minDate: Date = void 0;
   
    
    constructor(public router:Router, public route: ActivatedRoute, webAPIService: WebAPIService, public datepipe: DatePipe) {
        this.webAPIService = webAPIService;
        this.datePipe = datepipe;
        
        this.product = new Product();
        this.productTypeList = new Array<ProductType>();
        this.product.productType = new ProductType();
        this.productSizeList = new Array<ProductSize>();
        this.product.productSize = new ProductSize();
        this.productCategoryList = new Array<ProductCategory>();
        this.product.productCategory = new ProductCategory();
        this.amenities = new Array<Amenity>();
        this.availabilityList = new Array<Availability>();
        this.availabilities = new Array<Availability>();
        //this.selectedProductType = new ProductType();
        //this.selectedProductSize = new ProductSize();
        //this.selectedProductCategory = new ProductCategory();
        
        //this.productCategoryList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Room\"}, {\"id\":\"2\",\"title\":\"2 Room\"}, {\"id\":\"3\",\"title\":\"3 Room\"}, {\"id\":\"4\",\"title\":\"4 Room\"}, {\"id\":\"5\",\"title\":\"5 Room\"}]");
        //this.productSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Bed\"}, {\"id\":\"2\",\"title\":\"2 Bed\"}, {\"id\":\"3\",\"title\":\"3 Bed\"}, {\"id\":\"4\",\"title\":\"4 Bed\"}, {\"id\":\"5\",\"title\":\"5 Bed\"}]");
        //this.selectedProductSize = this.productSizeList[2];
        //this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Flat/Apartment\"}, {\"id\":\"2\",\"title\":\"House\"}, {\"id\":\"3\",\"title\":\"Property\"}]");
        //this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        //this.areaList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
        //this.amenityList = JSON.parse("[{\"id\":\"1\",\"title\":\"Parking\"}, {\"id\":\"2\",\"title\":\"Balcony/patio\"}, {\"id\":\"3\",\"title\":\"Garden/roof terrace\"}, {\"id\":\"4\",\"title\":\"Disabled access\"}, {\"id\":\"5\",\"title\":\"Garage\"}]");
        //this.occupationList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"Student\"}, {\"id\":\"3\",\"title\":\"Professional\"}]");
        //this.smokingList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"No\"}]");
        //this.petList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Preference\"}, {\"id\":\"2\",\"title\":\"No\"}]");
        //this.minStayList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Minimum\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"3\",\"title\":\"2 Day\"}, {\"id\":\"4\",\"title\":\"3 Day\"}, {\"id\":\"5\",\"title\":\"1 Week\"}, {\"id\":\"6\",\"title\":\"2 Week\"}, {\"id\":\"7\",\"title\":\"1 Month\"}, {\"id\":\"8\",\"title\":\"2 Month\"}]");
        //this.maxStayList = JSON.parse("[{\"id\":\"1\",\"title\":\"No Maximum\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"2\",\"title\":\"1 Day\"}, {\"id\":\"3\",\"title\":\"2 Day\"}, {\"id\":\"4\",\"title\":\"3 Day\"}, {\"id\":\"5\",\"title\":\"1 Week\"}, {\"id\":\"6\",\"title\":\"2 Week\"}, {\"id\":\"7\",\"title\":\"1 Month\"}, {\"id\":\"8\",\"title\":\"2 Month\"}]");
        
        this.uploader.onCompleteItem = (item: any, response: any, status: any, headers:any)=>  {
            console.log(response);
            if (this.product.images == null || this.product.images.length == 0)
            {
                this.product.images = new Array<Image>();
                let image: Image = new Image();
                image.title = response;
                this.product.images[0] = image;
                this.product.img = response;
            }
            else
            {
                let image: Image = new Image();
                image.title = response;
                this.product.images[this.product.images.length] = image;
            }
        }
        
        
    }
    
    ngOnInit() {
        this.subscribe = this.route.params.subscribe(params => {
            this.id = params['id'];
            //if we have valid id then get product info from the server
            if(this.id > 0)
            {
                this.requestProduct = new Product();
                this.responseProduct = new Product();
                this.requestProduct.id = this.id;
                let requestBody: string = JSON.stringify(this.requestProduct);
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_INFO), requestBody).then(result => {
                    this.product = result;
                    this.amenities = this.product.amenities;
                    this.availableFrom = new Date(this.product.availableFrom);
                    this.availabilities = this.product.availabilities;
                    //set or update product fields into interface
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
                        if(result.productTypes != null)
                        {
                            this.productTypeList = result.productTypes;
                            //set product type matching id
                            if (this.productTypeList.length > 0)
                            {
                                for (let counter = 0; counter < this.productTypeList.length; counter++)
                                {
                                    if (this.productTypeList[counter].id == this.product.productType.id)
                                    {
                                        this.product.productType = this.productTypeList[counter];
                                    }
                                }
                            }
                        }            
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_SIZE_LIST)).then(result => {
                        if(result.productSizes != null)
                        {
                            this.productSizeList = result.productSizes;
                            if (this.productSizeList.length > 0)
                            {
                                for (let counter = 0; counter < this.productSizeList.length; counter++)
                                {
                                    if (this.productSizeList[counter].id == this.product.productSize.id)
                                    {
                                        this.product.productSize = this.productSizeList[counter];
                                    }
                                }
                                //this.product.productSize = this.productSizeList[0];
                            }
                        }            
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_CATEGORY_LIST)).then(result => {
                        if(result.productCategories != null)
                        {
                            this.productCategoryList = result.productCategories;
                            if (this.productCategoryList.length > 0)
                            {
                                for (let counter = 0; counter < this.productCategoryList.length; counter++)
                                {
                                    if (this.productCategoryList[counter].id == this.product.productCategory.id)
                                    {
                                        this.product.productCategory = this.productCategoryList[counter];
                                    }
                                }
                                //this.product.productCategory = this.productCategoryList[0];
                            }
                        }
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
                        if(result.locations != null)
                        {
                            this.locationList = result.locations;
                            if (this.locationList.length > 0)
                            {
                                this.product.location = this.locationList[0];
                            }
                        }
                        //this.locationList = result.locations;
                        //this.product.location = this.locationList[0];
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_AMENITY_LIST)).then(result => {
                        if(result.amenities != null)
                        {
                            this.amenityList = result.amenities;
                        }
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_AVAILABILITY_LIST)).then(result => {
                        if(result.availabilities != null)
                        {
                            this.availabilityList = result.availabilities;
                        }
                    });
                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_STAY_LIST)).then(result => {
                        if(result.stays != null)
                        {
                            this.minStayList = result.stays;
                            if (this.minStayList.length > 0)
                            {
                                for (let counter = 0; counter < this.minStayList.length; counter++)
                                {
                                    if (this.minStayList[counter].id == this.product.minStay.id)
                                    {
                                        this.product.minStay = this.minStayList[counter];
                                    }
                                }
                                //this.product.minStay = this.minStayList[0];
                            }
                            this.maxStayList = result.stays;
                            if (this.maxStayList.length > 0)
                            {
                                for (let counter = 0; counter < this.maxStayList.length; counter++)
                                {
                                    if (this.maxStayList[counter].id == this.product.maxStay.id)
                                    {
                                        this.product.maxStay = this.maxStayList[counter];
                                    }
                                }
                                //this.product.maxStay = this.maxStayList[0];
                            }
                        }
                        //this.minStayList = result.stays;
                        //this.product.minStay = this.minStayList[0];
                        //this.maxStayList = result.stays;
                        //this.product.maxStay = this.minStayList[0];
                    });

                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_SMOKING_LIST)).then(result => {
                        if(result.smokings != null)
                        {
                            this.smokingList = result.smokings;
                            if (this.smokingList.length > 0)
                            {
                                for (let counter = 0; counter < this.smokingList.length; counter++)
                                {
                                    if (this.smokingList[counter].id == this.product.smoking.id)
                                    {
                                        this.product.smoking = this.smokingList[counter];
                                    }
                                }
                                //this.product.smoking = this.smokingList[0];
                            }
                        }
                        //this.smokingList = result.smokings;
                        //this.product.smoking = this.smokingList[0];
                    });

                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_OCCUPATION_LIST)).then(result => {
                        if(result.occupations != null)
                        {
                            this.occupationList = result.occupations;
                            if (this.occupationList.length > 0)
                            {
                                for (let counter = 0; counter < this.occupationList.length; counter++)
                                {
                                    if (this.occupationList[counter].id == this.product.occupation.id)
                                    {
                                        this.product.occupation = this.occupationList[counter];
                                    }
                                }
                                //this.product.occupation = this.occupationList[0];
                            }
                        }
                        //this.occupationList = result.occupations;
                        //this.product.occupation = this.occupationList[0];
                    });

                    this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PET_LIST)).then(result => {
                        if(result.pets != null)
                        {
                            this.petList = result.pets;
                            if (this.petList.length > 0)
                            {
                                for (let counter = 0; counter < this.petList.length; counter++)
                                {
                                    if (this.petList[counter].id == this.product.pet.id)
                                    {
                                        this.product.pet = this.petList[counter];
                                    }
                                }
                                //this.product.pet = this.petList[0];
                            }
                        }
                        //this.petList = result.pets;
                        //this.product.pet = this.petList[0];
                    });
                });
            }
            else
            {
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
                    if(result.productTypes != null)
                    {
                        this.productTypeList = result.productTypes;
                        if (this.productTypeList.length > 0)
                        {
                            this.product.productType = this.productTypeList[0];
                        }
                    }            
                });
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_SIZE_LIST)).then(result => {
                    if(result.productSizes != null)
                    {
                        this.productSizeList = result.productSizes;
                        if (this.productSizeList.length > 0)
                        {
                            this.product.productSize = this.productSizeList[0];
                        }
                    }            
                });
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_CATEGORY_LIST)).then(result => {
                    if(result.productCategories != null)
                    {
                        this.productCategoryList = result.productCategories;
                        if (this.productCategoryList.length > 0)
                        {
                            this.product.productCategory = this.productCategoryList[0];
                        }
                    }
                });
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
                    if(result.locations != null)
                    {
                        this.locationList = result.locations;
                        if (this.locationList.length > 0)
                        {
                            this.product.location = this.locationList[0];
                        }
                    }
                    //this.locationList = result.locations;
                    //this.product.location = this.locationList[0];
                });
                
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_AMENITY_LIST)).then(result => {
                    if(result.amenities != null)
                    {
                        this.amenityList = result.amenities;
                    }
                });
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_AVAILABILITY_LIST)).then(result => {
                    if(result.availabilities != null)
                    {
                        this.availabilityList = result.availabilities;
                    }
                });
                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_STAY_LIST)).then(result => {
                    if(result.stays != null)
                    {
                        this.minStayList = result.stays;
                        if (this.minStayList.length > 0)
                        {
                            this.product.minStay = this.minStayList[0];
                        }
                        this.maxStayList = result.stays;
                        if (this.maxStayList.length > 0)
                        {
                            this.product.maxStay = this.maxStayList[0];
                        }
                    }
                    //this.minStayList = result.stays;
                    //this.product.minStay = this.minStayList[0];
                    //this.maxStayList = result.stays;
                    //this.product.maxStay = this.minStayList[0];
                });

                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_SMOKING_LIST)).then(result => {
                    if(result.smokings != null)
                    {
                        this.smokingList = result.smokings;
                        if (this.smokingList.length > 0)
                        {
                            this.product.smoking = this.smokingList[0];
                        }
                    }
                    //this.smokingList = result.smokings;
                    //this.product.smoking = this.smokingList[0];
                });

                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_OCCUPATION_LIST)).then(result => {
                    if(result.occupations != null)
                    {
                        this.occupationList = result.occupations;
                        if (this.occupationList.length > 0)
                        {
                            this.product.occupation = this.occupationList[0];
                        }
                    }
                    //this.occupationList = result.occupations;
                    //this.product.occupation = this.occupationList[0];
                });

                this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PET_LIST)).then(result => {
                    if(result.pets != null)
                    {
                        this.petList = result.pets;
                        if (this.petList.length > 0)
                        {
                            this.product.pet = this.petList[0];
                        }
                    }
                    //this.petList = result.pets;
                    //this.product.pet = this.petList[0];
                });
            }
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    //onDropdownProductTypeChange(event: any) 
    //{
        //this.product.productType = new ProductType();
        //this.product.productType = event;  
        //this.selectedProductType = event;    
        //console.log(this.product.productType);
    //}
//    onDropdownProductSizeChange(event: any) 
//    {
//        this.product.productSize = new ProductSize();
//        this.product.productSize.id = event;    
//    }
//    onDropdownProductCategoryChange(event: any) 
//    {
//        this.product.productCategory = new ProductCategory();
//        this.product.productCategory.id = event;      
//    }
    
    saveProduct(event: Event) 
    {
        this.product.availableFrom = this.datepipe.transform(this.availableFrom, 'yyyy-MM-dd');
        this.product.amenities = this.amenities;
        this.product.availabilities = this.availabilities;
        let requestBody: string = JSON.stringify(this.product);
        if(this.id == 0)
        {
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_PRODUCT), requestBody).then(result =>{
                let response  = result;
                if (response.success)
                {
                    this.router.navigate(['myads']);
                }
                else
                {
                    //show error message at this page
                }
            });
        }
        else
        {
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.UPDATE_PRODUCT_INFO), requestBody).then(result =>{
                let response  = result;
                if (response.success)
                {
                    this.router.navigate(['myads']);
                }
                else
                {
                    //show error message at this page
                }
            });
        }
    }
    
    setCurrentAmenities(id: number)
    {
        if (this.amenities.length > 0)
        {
            for (let counter = 0; counter < this.amenities.length; counter++)
            {
                if (this.amenities[counter].id == id)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    updateCheckedAmenities(amenity: Amenity, event: Event)
    {
        this.tempAmenities = new Array<Amenity>();
        let exist: Boolean = false;
        if (this.amenities.length > 0)
        {
            for (let counter = 0; counter < this.amenities.length; counter++)
            {
                if (this.amenities[counter].id == amenity.id)
                {
                    exist = true;
                }
                else
                {
                    this.tempAmenities[this.tempAmenities.length] = this.amenities[counter];
                }
            }
        }
        if (!exist)
        {
            this.tempAmenities[this.tempAmenities.length] = amenity;
        }
        this.amenities = this.tempAmenities;
    }
    
    setCurrentAvailabilities(id: number)
    {
        if (this.availabilities.length > 0)
        {
            for (let counter = 0; counter < this.availabilities.length; counter++)
            {
                if (this.availabilities[counter].id == id)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    updateCheckedAvailabilities(availability: Availability, event: Event)
    {
        this.tempAvailabilities = new Array<Availability>();
        let exist: Boolean = false;
        if (this.availabilities.length > 0)
        {
            for (let counter = 0; counter < this.availabilities.length; counter++)
            {
                if (this.availabilities[counter].id == availability.id)
                {
                    exist = true;
                }
                else
                {
                    this.tempAvailabilities[this.tempAvailabilities.length] = this.availabilities[counter];
                }
            }
        }
        if (!exist)
        {
            this.tempAvailabilities[this.tempAvailabilities.length] = availability;
        }
        this.availabilities = this.tempAvailabilities;
    }
}
