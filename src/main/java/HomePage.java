import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    SearchBox searchBox ;
    By cartCountLocator = By.id("spanCart");
    By cartContainerLocator = new By.ByCssSelector("header-bag-icon bndl-shopping-bag bndl-shopping-bag-dims");
    public HomePage(WebDriver driver){
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 1;
    }

    public void gotoCart() {
        click(cartCountLocator);
    }
    private int getCartCount() {
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

}
