
package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Resources')]")
    private WebElement resourcesBtnElement;

    @FindBy(css = "a[href='/career']")
    private WebElement careersBtnElement;

    public void goToCareersPage() {
        waitForVisibilityOf(cookiesBtnElement);
        cookiesBtnElement.click();
        resourcesBtnElement.click();
        waitForVisibilityOf(careersBtnElement);
        careersBtnElement.click();

    }
}
