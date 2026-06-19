import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends BasePage {

    private final By usernameInput = By.name("username");
    private final By passwordField = By.name("password");
    private final By passwordConfirm = By.name("passwordConfirm");
    private final By emailInput = By.name("email");
    private final By registerButton = By.xpath("//button[text()='Register']");
    private final By errorMessage = By.xpath("//span[normalize-space()='Username is already taken.']");

    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterPasswordConfirm(String password) {
        driver.findElement(passwordConfirm).sendKeys(password);
    }

    public void clickOnRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void registerUser(String username, String password, String email) {
        enterName(username);
        enterEmail(email);
        enterPassword(password);
        enterPasswordConfirm(password);
        clickOnRegisterButton();
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }
}
