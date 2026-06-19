import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage{

    private final By firstNumberInput = By.xpath("//input[@name='number1']");
    private final By secondNumberInput = By.xpath("//input[@name='number2']");
    private final By calculateButton = By.xpath("//button[normalize-space()='Calculate']");
    private final By calcResult = By.cssSelector(".calculateContainer h1");
    private final By errMessage = By.xpath("//span[@class='error-message']");
    private final By operationSelect = By.xpath("//select[@name='operation']");



    public void enterFirstNumber(String Number){
        driver.findElement(firstNumberInput).sendKeys(Number);
    }

    public void enterSecondNumber(String Number){
        driver.findElement(secondNumberInput).sendKeys(Number);
    }

    public void clickOnCalculateButton(){
        driver.findElement(calculateButton).click();
    }

    public void calculate(String firstNumber, String secondNumber){
        enterFirstNumber(firstNumber);
        enterSecondNumber(secondNumber);
        clickOnCalculateButton();
    }

    public String getResult(){
        return driver.findElement(calcResult).getText();
    }

    public String getErrMessage(){
        return driver.findElement(errMessage).getText();
    }

    public void clickDivision(){
        WebElement selectElement = driver.findElement(operationSelect);
        Select dropdown = new Select(selectElement);
        dropdown.selectByValue("/");
    }


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
}
