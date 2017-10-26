import {Component, ViewChild} from '@angular/core';
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
import {BidTime} from '../dto/BidTime'
import {WebAPIService} from './../webservice/web-api-service';
import {PacketHeaderFactory} from './../webservice/PacketHeaderFactory';
import {ACTION} from './../webservice/ACTION';
import { FileUploader } from 'ng2-file-upload';
import { ModalDirective } from 'ngx-bootstrap';

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
    
    private fetchProductInfoCounter:number = 0;
    private fetchProductTypeCounter:number = 0;
    private fetchProductSizeCounter:number = 0;
    private fetchProductCategoryCounter:number = 0;
    private fetchLocationCounter:number = 0;
    private fetchAmenityCounter:number = 0;
    private fetchAvailabilityCounter:number = 0;
    private fetchStayCounter:number = 0;
    private fetchSmokingCounter:number = 0;
    private fetchOccupationCounter:number = 0;
    private fetchPetCounter: number = 0;
    private fetchBidTimeCounter: number = 0;
    
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
    
    private availableTimeList: General[];
    private bidTimeList: BidTime[];
    
    private selectedBidStartTime: BidTime;
    private selectedBidEndTime: BidTime;
    
    //private durationList: General[];    
    private showAvailableFromDatePicker: boolean = false;
    private showAvailableToDatePicker: boolean = false;
    private showBidStartDateDatePicker: boolean = false;
    private showBidEndDateDatePicker: boolean = false;
    
    public availableFrom: Date = new Date();
    public availableTo: Date = new Date();
    public bidStartDate: Date = new Date();
    public bidEndDate: Date = new Date();
    
    public minDate: Date = void 0;
    public minDate2: Date = void 0;
    
    public successMessage:string;
    public errorMessage:string;
    @ViewChild('manageProductModal') public manageProductModal:ModalDirective;
   
    
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
        this.bidTimeList = new Array<BidTime>();
        //this.selectedProductType = new ProductType();
        //this.selectedProductSize = new ProductSize();
        //this.selectedProductCategory = new ProductCategory();
        this.availableTimeList = JSON.parse("[{\"id\":\"12 AM\",\"title\":\"12 AM\"}, {\"id\":\"1 AM\",\"title\":\"1 AM\"}, {\"id\":\"2 AM\",\"title\":\"2 AM\"}, {\"id\":\"3 AM\",\"title\":\"3 AM\"}, {\"id\":\"4 AM\",\"title\":\"4 AM\"}, {\"id\":\"5 AM\",\"title\":\"5 AM\"}, {\"id\":\"6 AM\",\"title\":\"6 AM\"}, {\"id\":\"7 AM\",\"title\":\"7 AM\"}, {\"id\":\"8 AM\",\"title\":\"8 AM\"}, {\"id\":\"9 AM\",\"title\":\"9 AM\"}, {\"id\":\"10 AM\",\"title\":\"10 AM\"}, {\"id\":\"11 AM\",\"title\":\"11 AM\"}, {\"id\":\"12 PM\",\"title\":\"12 PM\"}, {\"id\":\"1 PM\",\"title\":\"1 PM\"}, {\"id\":\"2 PM\",\"title\":\"2 PM\"}, {\"id\":\"3 PM\",\"title\":\"3 PM\"}, {\"id\":\"4 PM\",\"title\":\"4 PM\"}, {\"id\":\"5 PM\",\"title\":\"5 PM\"}, {\"id\":\"6 PM\",\"title\":\"6 PM\"}, {\"id\":\"7 PM\",\"title\":\"7 PM\"}, {\"id\":\"8 PM\",\"title\":\"8 PM\"}, {\"id\":\"9 PM\",\"title\":\"9 PM\"}, {\"id\":\"10 PM\",\"title\":\"10 PM\"}, {\"id\":\"11 PM\",\"title\":\"11 PM\"}]");
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
        
        setInterval(() => { this.manageProductModal.hide(); }, 1000 * 5);
        
    }
    
    public hideChildModal(): void {
        this.manageProductModal.hide();
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
                this.fetchProductInfo();
            }
            else
            {
                //setting any default data for product info
                this.fetchProductTypeList();
                this.fetchProductSizeList();
                this.fetchProductCategoryList();
                this.fetchLocationList();
                this.fetchAmenityList();
                this.fetchAvailabilityList();
                this.fetchStayList();
                this.fetchSmokingList();
                this.fetchOccupationList();
                this.fetchPetList();
                this.fetchBidTimeList();
            }
        });
    }

    ngOnDestroy() {
        this.subscribe.unsubscribe();
    }
    
    public fetchProductInfo()
    {
        let requestBody: string = JSON.stringify(this.requestProduct);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_INFO), requestBody).then(result => {
            if(result.success)
            {
                this.product = result;
                this.amenities = this.product.amenities;
                this.availableFrom = new Date(this.product.availableFrom);
                this.availableTo = new Date(this.product.availableTo);
                this.bidStartDate = new Date(this.product.bidStartDate);
                this.bidEndDate = new Date(this.product.bidEndDate);
                this.availabilities = this.product.availabilities;
                //set or update product fields into interface
                this.fetchProductTypeList();
                this.fetchProductSizeList();
                this.fetchProductCategoryList();
                this.fetchLocationList();
                this.fetchAmenityList();
                this.fetchAvailabilityList();
                this.fetchStayList();
                this.fetchSmokingList();
                this.fetchOccupationList();
                this.fetchPetList();
                this.fetchBidTimeList();
            }
            else
            {
                this.fetchProductInfoCounter++;
                if (this.fetchProductInfoCounter <= 5)
                {
                    this.fetchProductInfo();
                }
            }
        });
    }
    
    
    public fetchProductTypeList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_TYPE_LIST)).then(result => {
            if(result.success && result.productTypes != null)
            {
                this.productTypeList = result.productTypes;
                //set product type matching id
                if (this.productTypeList.length > 0)
                {
                    if(this.id > 0 )
                    {
                        for (let counter = 0; counter < this.productTypeList.length; counter++)
                        {
                            if (this.productTypeList[counter].id == this.product.productType.id)
                            {
                                this.product.productType = this.productTypeList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.productType = this.productTypeList[0];
                    }                    
                }
            } 
            else
            {
                this.fetchProductTypeCounter++;
                if (this.fetchProductTypeCounter <= 5)
                {
                    this.fetchProductTypeList();
                }
            }           
        });
    }
    
    
    public fetchProductSizeList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_SIZE_LIST)).then(result => {
            if(result.success && result.productSizes != null)
            {
                this.productSizeList = result.productSizes;
                if (this.productSizeList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.productSizeList.length; counter++)
                        {
                            if (this.productSizeList[counter].id == this.product.productSize.id)
                            {
                                this.product.productSize = this.productSizeList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.productSize = this.productSizeList[0];
                    }
                }
                else
                {
                    this.fetchProductSizeCounter++;
                    if (this.fetchProductSizeCounter <= 5)
                    {
                        this.fetchProductSizeList();
                    }
                }
            }            
        });
    }
    
    public fetchProductCategoryList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_CATEGORY_LIST)).then(result => {
            if(result.success && result.productCategories != null)
            {
                this.productCategoryList = result.productCategories;
                if (this.productCategoryList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.productCategoryList.length; counter++)
                        {
                            if (this.productCategoryList[counter].id == this.product.productCategory.id)
                            {
                                this.product.productCategory = this.productCategoryList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.productCategory = this.productCategoryList[0];
                    }                    
                }
            }
            else
            {
                this.fetchProductCategoryCounter++;
                if (this.fetchProductCategoryCounter <= 5)
                {
                    this.fetchProductCategoryList();
                }
            }
        });
    }
    
    public fetchLocationList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_LOCATION_LIST)).then(result => {
            if(result.success && result.locations != null)
            {
                this.locationList = result.locations;
                if (this.locationList.length > 0)
                {
                    this.product.location = this.locationList[0];
                }
            }
            else
            {
                this.fetchLocationCounter++;
                if (this.fetchLocationCounter <= 5)
                {
                    this.fetchLocationList();
                }
            }
        });
    }
    
    public fetchAmenityList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PRODUCT_AMENITY_LIST)).then(result => {
            if(result.success && result.amenities != null)
            {
                this.amenityList = result.amenities;
            }
            else
            {
                this.fetchAmenityCounter++;
                if (this.fetchAmenityCounter <= 5)
                {
                    this.fetchAmenityList();
                }
            }
        });
    }
    
    public fetchAvailabilityList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_AVAILABILITY_LIST)).then(result => {
            if(result.success && result.availabilities != null)
            {
                this.availabilityList = result.availabilities;
            }
            else
            {
                this.fetchAvailabilityCounter++;
                if (this.fetchAvailabilityCounter <= 5)
                {
                    this.fetchAvailabilityList();
                }
            }
        });
    }

    public fetchStayList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_STAY_LIST)).then(result => {
            if(result.success && result.stays != null)
            {
                this.minStayList = result.stays;
                if (this.minStayList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.minStayList.length; counter++)
                        {
                            if (this.minStayList[counter].id == this.product.minStay.id)
                            {
                                this.product.minStay = this.minStayList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.minStay = this.minStayList[0];
                    }
                }
                this.maxStayList = result.stays;
                if (this.maxStayList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.maxStayList.length; counter++)
                        {
                            if (this.maxStayList[counter].id == this.product.maxStay.id)
                            {
                                this.product.maxStay = this.maxStayList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.maxStay = this.maxStayList[0];
                    }
                }
            }
            else
            {
                this.fetchStayCounter++;
                if (this.fetchStayCounter <= 5)
                {
                    this.fetchStayList();
                }
            }
        });
    }
    
    public fetchSmokingList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_SMOKING_LIST)).then(result => {
            if(result.success && result.smokings != null)
            {
                this.smokingList = result.smokings;
                if (this.smokingList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.smokingList.length; counter++)
                        {
                            if (this.smokingList[counter].id == this.product.smoking.id)
                            {
                                this.product.smoking = this.smokingList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.smoking = this.smokingList[0];
                    }                    
                }
            }
            else
            {
                this.fetchSmokingCounter++;
                if (this.fetchSmokingCounter <= 5)
                {
                    this.fetchSmokingList();
                }
            }
        });
    }
    
    public fetchOccupationList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_OCCUPATION_LIST)).then(result => {
            if(result.success && result.occupations != null)
            {
                this.occupationList = result.occupations;
                if (this.occupationList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.occupationList.length; counter++)
                        {
                            if (this.occupationList[counter].id == this.product.occupation.id)
                            {
                                this.product.occupation = this.occupationList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.occupation = this.occupationList[0];
                    }                    
                }
            }
            else
            {
                this.fetchOccupationCounter++;
                if (this.fetchOccupationCounter <= 5)
                {
                    this.fetchOccupationList();
                }
            }
        });
    }
    
    public fetchPetList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_PET_LIST)).then(result => {
            if(result.success && result.pets != null)
            {
                this.petList = result.pets;
                if (this.petList.length > 0)
                {
                    if(this.id > 0)
                    {
                        for (let counter = 0; counter < this.petList.length; counter++)
                        {
                            if (this.petList[counter].id == this.product.pet.id)
                            {
                                this.product.pet = this.petList[counter];
                            }
                        }
                    }
                    else
                    {
                        this.product.pet = this.petList[0];
                    }                    
                }
            }
            else
            {
                this.fetchPetCounter++;
                if (this.fetchPetCounter <= 5)
                {
                    this.fetchPetList();
                }
            }
        });
    }
    
    public fetchBidTimeList()
    {
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.FETCH_BID_TIME_LIST)).then(result => {
            if(result.success && result.bidTimes != null)
            {
                this.bidTimeList = result.bidTimes;
                if (this.product.id > 0)
                {
                    let counter: number = 0;
                    for (counter = 0; counter < this.bidTimeList.length; counter++)
                    {
                        if (this.product.bidStartTime == this.bidTimeList[counter].title)
                        {
                            this.selectedBidStartTime = this.bidTimeList[counter];
                        }
                        if (this.product.bidEndTime == this.bidTimeList[counter].title)
                        {
                            this.selectedBidEndTime = this.bidTimeList[counter];
                        }
                    }
                }
                else
                {
                    if (this.bidTimeList.length > 0)
                    {
                        this.selectedBidStartTime = this.bidTimeList[0];
                        this.selectedBidEndTime = this.bidTimeList[0]; 
                    }
                }
                console.log(this.selectedBidStartTime);
                console.log(this.selectedBidEndTime);
            } 
            else
            {
                this.fetchBidTimeCounter++;
                if (this.fetchBidTimeCounter <= 5)
                {
                    this.fetchBidTimeList();
                }
            }           
        });
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
        this.product.availableTo = this.datepipe.transform(this.availableTo, 'yyyy-MM-dd');
        this.product.bidStartDate = this.datepipe.transform(this.bidStartDate, 'yyyy-MM-dd');
        this.product.bidEndDate = this.datepipe.transform(this.bidEndDate, 'yyyy-MM-dd');
        
        this.product.amenities = this.amenities;
        this.product.availabilities = this.availabilities;
        this.product.bidStartTime = this.selectedBidStartTime.title;
        this.product.bidEndTime = this.selectedBidEndTime.title;
        
        let requestBody: string = JSON.stringify(this.product);
        if(this.id == 0)
        {
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_PRODUCT), requestBody).then(result =>{
                let response  = result;                
                if (response.success)
                {
                    //modal pop up will not work after navigation, so it is commented.
                    //this.successMessage = "Your ad is created successfully.";
                    //this.manageProductModal.show();
                    this.router.navigate(['myads']);
                }
                else
                {
                    this.errorMessage = "Unable to create your ad. Please try again.";
                    this.manageProductModal.show();
                }
            });
        }
        else
        {
            this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.UPDATE_PRODUCT_INFO), requestBody).then(result =>{
                let response  = result;
                if (response.success)
                {
                    //modal pop up will not work after navigation, so it is commented.
                    //this.successMessage = "Your ad is updated successfully.";
                    //this.manageProductModal.show();
                    this.router.navigate(['myads']);
                }
                else
                {
                    this.errorMessage = "Unable to update your ad. Please try again.";
                    this.manageProductModal.show();
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
