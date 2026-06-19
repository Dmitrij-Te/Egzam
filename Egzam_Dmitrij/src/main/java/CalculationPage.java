import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculationPage extends BasePage{

    private final By firstNumFirstRow = By.xpath("//table[@class='table table-striped']//tr[2]/td[1]");
    private final By secondNumFirstRow = By.xpath("//table[@class='table table-striped']//tr[2]/td[3]");
    private final By usernameFirstRow = By.xpath("//table[@class='table table-striped']//tr[2]/td[5]");
    private final By calculationButton = By.xpath("//button[text()='Calculations']");

    public void clickCalculationButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(calculationButton)).click();
    }

    public String getFirstNumber(){
        return driver.findElement(firstNumFirstRow).getText();
    }

    public String getSecondNumber(){
        return driver.findElement(secondNumFirstRow).getText();
    }

    public String getUserName(){
        return driver.findElement(usernameFirstRow).getText();
    }

    public int getRowsCount() {
        return driver.findElements(By.xpath("//table[@class='table table-striped']//tr[td]")).size();
    }


    public CalculationPage(WebDriver driver) {
        super(driver);
    }
}
