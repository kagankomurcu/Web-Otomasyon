import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SearchProduct extends BaseTest{

    HomePage homePage ;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;


    @Test
    @Order(1)
    public void urunu_arama(){
        homePage= new HomePage(driver);
        productsPage = new ProductsPage (driver);
    homePage.searchBox().search("pantalon");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page");
        }


    @Test
    @Order(2)
    public void select(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage() ,
                "Not on product detail page!");



    }
    @Test
    @Order(3)
    public void sepete_ekleme(){
        productDetailPage.addTocart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");

    }
    @Test
    @Order(3)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.gotoCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),
                "Product was not added to card!" );

    }
}
