import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

    By searchBoxLocator = By.id("search_input");
    By submitButtonLocator = new By.ByCssSelector("search-button");


    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator, text);
        click(submitButtonLocator);
    }
}
