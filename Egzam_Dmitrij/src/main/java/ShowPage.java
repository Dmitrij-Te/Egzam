import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShowPage extends BasePage{

    private final By firstNumberValue = By.xpath("//td[b[contains(text(), 'First number')]]/following-sibling::td");
    private final By secondNumberValue = By.xpath("//td[b[contains(text(), 'Second number')]]/following-sibling::td");


    public String getFirstNumberValue(){
        return driver.findElement(firstNumberValue).getText();
    }

    public String getSecondNumberValue(){
        return driver.findElement(secondNumberValue).getText();
    }


    public ShowPage(WebDriver driver) {
        super(driver);
    }
}
