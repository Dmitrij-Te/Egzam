import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    private final By usernameInput = By.name("username");
    private final By Password = By.name("password");
    private final By loginButton = By.className("btn-login");
    private final By registerButton = By.xpath("//button[text()='Register']");
    private final By errorMessage = By.xpath("//div[@class='error-message-login']");

    public void enterName(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(Password).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void loginUser(String username, String password){
        enterName(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void clickOnRegistrationButton(){

        //driver.findElement(registerButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
