import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {User} from '../dto/User'
import {Product} from '../dto/Product'
import {Image} from '../dto/Image'
import {General} from '../dto/General'
import {ProductType} from '../dto/ProductType'
import {ProductSize} from '../dto/ProductSize'
import {ProductCategory} from '../dto/ProductCategory'
import {Location} from '../dto/Location'
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
    providers: [WebAPIService]
})
export class DashBoard {
    public uploader:FileUploader = new FileUploader({url: URL});
    private webAPIService: WebAPIService;
    private product: Product;
    //private images: Image[];
    private productTypeList: ProductType[];
    private productSizeList: ProductSize[];    
    private productCategoryList: ProductCategory[];
    //private selectedProductType: ProductType;
    //private selectedProductSize: ProductSize;
    //private selectedProductCategory: ProductCategory; 
    private locationList: Location[];   
    private minStayList: Stay[];
    private maxStayList: Stay[];
    private smokingList: Smoking[];
    private occupationList: Occupation[];    
    private petList: Pet[];
    //private roomList: General[];
    
    private durationList: General[];    
    private amenityList: General[];
   
    
    constructor(public router: Router, public http: Http, webAPIService: WebAPIService) {
        this.webAPIService = webAPIService;
        this.product = new Product();
        this.productTypeList = new Array<ProductType>();
        this.product.productType = new ProductType();
        this.productSizeList = new Array<ProductSize>();
        this.product.productSize = new ProductSize();
        this.productCategoryList = new Array<ProductCategory>();
        this.product.productCategory = new ProductCategory();
        //this.selectedProductType = new ProductType();
        //this.selectedProductSize = new ProductSize();
        //this.selectedProductCategory = new ProductCategory();
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
        
        
        //this.productCategoryList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Room\"}, {\"id\":\"2\",\"title\":\"2 Room\"}, {\"id\":\"3\",\"title\":\"3 Room\"}, {\"id\":\"4\",\"title\":\"4 Room\"}, {\"id\":\"5\",\"title\":\"5 Room\"}]");
        //this.productSizeList = JSON.parse("[{\"id\":\"1\",\"title\":\"1 Bed\"}, {\"id\":\"2\",\"title\":\"2 Bed\"}, {\"id\":\"3\",\"title\":\"3 Bed\"}, {\"id\":\"4\",\"title\":\"4 Bed\"}, {\"id\":\"5\",\"title\":\"5 Bed\"}]");
        //this.selectedProductSize = this.productSizeList[2];
        //this.productTypeList = JSON.parse("[{\"id\":\"1\",\"title\":\"Flat/Apartment\"}, {\"id\":\"2\",\"title\":\"House\"}, {\"id\":\"3\",\"title\":\"Property\"}]");
        this.durationList = JSON.parse("[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]");
        //this.areaList = JSON.parse("[{\"id\":\"1\", \"locationType\":\"area\",\"searchString\":\"London\"}, {\"id\":\"2\", \"locationType\":\"area\",\"searchString\":\"London 123\"}, {\"id\":\"3\", \"locationType\":\"area\",\"searchString\":\"London 456\"}]");
        this.amenityList = JSON.parse("[{\"id\":\"1\",\"title\":\"Parking\"}, {\"id\":\"2\",\"title\":\"Balcony/patio\"}, {\"id\":\"3\",\"title\":\"Garden/roof terrace\"}, {\"id\":\"4\",\"title\":\"Disabled access\"}, {\"id\":\"5\",\"title\":\"Garage\"}]");
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
    
    addProduct(event: Event) 
    {
        let requestBody: string = JSON.stringify(this.product);
        this.webAPIService.getResponse(PacketHeaderFactory.getHeader(ACTION.ADD_PRODUCT), requestBody).then(result =>{
            let response  = result;
            if (response.success){
                window.location.replace("/");
                window.location.href = "manage-advert.jsp";
            }
            else{
                //show error message at this page
            }
        });
    }
    
    setCurrentAmenities(id: number)
    {
        if(id < 3)
        {
            return true;
        }
        return false;
    }
    
}
