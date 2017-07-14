/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.commons.HibernateProxyTypeAdapter;
import com.auction.dto.Currency;
import com.auction.dto.CurrencyUnit;
import com.auction.dto.Image;
import com.auction.dto.Location;
import com.auction.dto.Occupation;
import com.auction.dto.Pet;
import com.auction.dto.Product;
import com.auction.dto.ProductBid;
import com.auction.dto.ProductCategory;
import com.auction.dto.ProductList;
import com.auction.dto.ProductSize;
import com.auction.dto.ProductType;
import com.auction.dto.Smoking;
import com.auction.dto.Stay;
import com.auction.dto.User;
import com.auction.manager.ProductManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nazmul
 */
public class ProductManagerTest {
    
    public ProductManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //@Test
    public void getProductTypesTest(){
        ProductManager productManager = new ProductManager();
        List<ProductType> productTypes = productManager.getProductTypes();
        System.out.println(productTypes.size());
    }
    
    //@Test
    public void getProductSizesTest(){
        ProductManager productManager = new ProductManager();
        List<ProductSize> productSizes = productManager.getProductSizes();
        System.out.println(productSizes.size());
    }
    
    //@Test
    public void getProductCategoriesTest(){
        ProductManager productManager = new ProductManager();
        List<ProductCategory> productCategories = productManager.getProductCategories();
        System.out.println(productCategories.size());
    }
    
    //@Test
    public void getLocationsTest(){
        ProductManager productManager = new ProductManager();
        List<Location> locations = productManager.getLocations();
        System.out.println(locations.size());
    }
    
    //@Test
    public void getStaysTest(){
        ProductManager productManager = new ProductManager();
        List<Stay> stays = productManager.getStays();
        System.out.println(stays.size());
    }
    
    //@Test
    public void getSmokingsTest(){
        ProductManager productManager = new ProductManager();
        List<Smoking> smokings = productManager.getSmokings();
        System.out.println(smokings.size());
    }
    
    //@Test
    public void getOccupationsTest(){
        ProductManager productManager = new ProductManager();
        List<Occupation> occupations = productManager.getOccupations();
        System.out.println(occupations.size());
    }
    
    //@Test
    public void getPetsTest(){
        ProductManager productManager = new ProductManager();
        List<Pet> pets = productManager.getPets();
        System.out.println(pets.size());
    }
    
    //@Test
    public void getMyProductsTest(){
        ProductManager productManager = new ProductManager();
        List<Product> products = productManager.getMyProducts(1, 0, 100);
        System.out.println(products.size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void productParseTest() 
    {
        Product response = new Gson().fromJson("{\"id\":\"1\",\"productId\":\"p1\",\"user\":{\"id\":\"1\"},\"title\":\"Title of product1.\", \"description\":\"Description of product1.\",\"firstName\":\"Nazmul\",\"lastName\":\"Hasan\",\"phone\":\"01711123456\",\"img\":\"a.jpg\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"location\":{\"locationId\":\"1\", \"locationType\":\"area\", \"searchString\":\"London\", \"postCode\":\"AB2 8YR\"},\"productType\":{\"id\":\"1\"},\"productSize\":{\"id\":\"1\"},\"productCategory\":{\"id\":\"1\"}, \"amenities\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"smoking\":{\"id\":\"1\"},\"gender\":{\"id\":\"1\"},\"occupation\":{\"id\":\"1\"},\"pet\":{\"id\":\"1\"}, \"durations\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"basePrice\":\"100\", \"basePriceUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}},\"securityDeposit\":\"200\", \"securityDepositUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"startDate\":\"2017-05-10\", \"endDate\":\"2017-05-16\",\"minStay\":{\"id\":\"1\"},\"maxStay\":{\"id\":\"1\"}, \"isFeaturedAd\":\"true\", \"isDefaultBid\":\"false\",\"adBid\":\"0.3\", \"adBidUnit\":{\"id\":\"1\",\"title\":\"p\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}", Product.class );
        response.setSuccess(true);
    }
    
    //@Test
    public void addProducts(){
        ArrayList<Product> productList = new Gson().fromJson("[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"2\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£200\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£300\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£400\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"}, {\"id\":\"5\",\"title\":\"Fun at the Bowling Alley5\", \"img\":\"a.jpg\", \"price\":\"£500\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR5.\"}, {\"id\":\"6\",\"title\":\"Fun at the Bowling Alley6\", \"img\":\"a.jpg\", \"price\":\"£600\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR6.\"} ]", new TypeToken<ArrayList<Product>>(){}.getType());
        ProductManager manager = new ProductManager();
        User user = new User();
        user.setId(1);
        for (Product product : productList) {    
            product.setUser(user);
            Image[] images = product.getImages();
            product.setImages(null);
            manager.addProduct(product);
            manager.addProductImages(product.getId(), images);
        }
    }
    //@Test
    public void getProducts(){
        ProductManager manager = new ProductManager();
        
//        List products = manager.getProducts(1, 10);
//        products.forEach((product) -> {
//            
//            System.out.println(((Product)product).getTitle());
//        });
    }
    
    //@Test
    public void addProduct(){
        Product product = new Product();
        product.setTitle("product1");
        product.setDescription("description1");
        product.setFirstName("fn1");
        product.setLastName("ln1");
        product.setPhone("01711123456");
        User user = new User();
        user.setId(1);
        product.setUser(user);
        Image image1 = new Image();
        image1.setTitle("a.jpg");        
        Image image2 = new Image();
        image2.setTitle("b.jpg");        
        Image image3 = new Image();
        image3.setTitle("c.jpg");
        Image[] images = new Image[3];
        images[0] = image1;
        images[1] = image2;
        images[2] = image3;
        product.setImages(images);
        
        ProductManager productManager = new ProductManager();
        productManager.addProduct(product);        
    }
    
    @Test
    public void getProductInfoTest(){
        ProductManager manager = new ProductManager();
        Product prod = manager.getProductInfo(3);
        System.out.println(prod.getTitle());
    }
    
    //@Test
    public void addProductBidTest(){
        ProductManager productManager = new ProductManager();
        ProductBid productBid = new ProductBid();
        User user = new User();
        user.setId(1);
        Product product = new Product();
        product.setId(1);
        Currency currency = new Currency();
        currency.setId(1);
        CurrencyUnit currencyUnit = new CurrencyUnit();
        currencyUnit.setId(1);
        productBid.setUser(user);
        productBid.setProduct(product);
        productBid.setCurrency(currency);
        productBid.setCurrencyUnit(currencyUnit);
        productManager.addProductBid(productBid);
    }
    
    //@Test
    public void getProductBidListTest(){
        ProductManager productManager = new ProductManager();
        List<ProductBid> productBids = productManager.getProductBidList(1);
        System.out.println(productBids.size());
    }
    
    //@Test
    public void addSavedProductTest(){
        ProductManager productManager = new ProductManager();
        System.out.println(productManager.addSavedProduct(1, 1));
    }
    
    //@Test
    public void getSavedProductTest(){
        ProductManager productManager = new ProductManager();
        productManager.getSavedProducts(1, 0, 100);
    }
}
