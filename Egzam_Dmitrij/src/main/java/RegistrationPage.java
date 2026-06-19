import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utils.Waiters.waitForElemVisibility;

public class RegistrationPage extends BasePage{

    private final By usernameInput = By.name("username");
    private final By Password = By.name("password");
    private final By passwordConfirm = By.name("passwordConfirm");
    private final By emailInput = By.name("email");
    private final By registerButton = By.xpath("//button[text()='Register']");
    private final By errorMessage = By.xpath("//span[normalize-space()='Username is already taken.']");



    public void enterName(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(Password).sendKeys(password);
    }

    public void enterPasswordConfirm(String password){
        driver.findElement(passwordConfirm).sendKeys(password);
    }

    public void enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickOnRegisterButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(registerButton).click();
    }

    public void registerUser(String username, String password, String email){
        enterName(username);
        enterEmail(email);
        enterPassword(password);
        enterPasswordConfirm(password);
        clickOnRegisterButton();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
