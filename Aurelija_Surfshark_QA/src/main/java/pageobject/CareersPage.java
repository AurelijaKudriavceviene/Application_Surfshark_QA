
package pageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='Job title or keywords']")
    private WebElement searchingInputElement;

    @FindBy(css = "._D3jnl")
    private List<WebElement> jobElements;

    public boolean hasAJobTitle(String expectedJobTitle) {
        waitForVisibilityOf(searchingInputElement);
        searchingInputElement.sendKeys(expectedJobTitle);

        for (WebElement jobElement : jobElements) {
            String jobTitle = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", jobElement);
            if ((jobTitle != null) && jobTitle.contains(expectedJobTitle)) {
                return  true;
            }
        }
        return false;
    }
}
