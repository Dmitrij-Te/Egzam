import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditPage extends BasePage{
    private final By firstRowEdit = By.xpath("(//a[normalize-space()='Edit'])[1]");
    private final By firstNumber = By.cssSelector("input[name='number1']");
    private final By secondNumber = By.cssSelector("input[name='number2']");
    private final By updateButton = By.cssSelector("button.btn-update");
    private final By operationError = By.cssSelector(".error-message");
    private final By operationField = By.name("operation");

    //private final By updateButton = By.xpath("(///button[normalize-space()='Update']");




    public void clickFirstEdit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstRowEdit)).click();
    }

    public void changeFirstNumber(String newFirstNumber){
        driver.findElement(firstNumber).clear();
        driver.findElement(firstNumber).sendKeys(newFirstNumber);
    }

    public void changeSecondNumber(String newSecondNumber){
        driver.findElement(secondNumber).clear();
        driver.findElement(secondNumber).sendKeys(newSecondNumber);
    }

    public void clickUpdateButton(){
        driver.findElement(updateButton).click();
    }

    public void changeOperation(String num){
        driver.findElement(operationField).clear();
        driver.findElement(operationField).sendKeys(num);
        driver.findElement(updateButton).click();
    }

    public void changeData(String numFirst, String numSecond){
        changeFirstNumber(numFirst);
        changeSecondNumber(numSecond);
        clickUpdateButton();
    }

    public String getOperationErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(operationError)).getText();
    }

    public EditPage(WebDriver driver) {
        super(driver);
    }
}
