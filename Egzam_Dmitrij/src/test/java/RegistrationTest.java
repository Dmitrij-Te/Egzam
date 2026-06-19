import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest{
    RegistrationPage registrationPage;
    LoginPage loginPage;

    String username = "user7";
    String password = "Password123";
    String email = "user7@email.com";

    String usernameExist = "user";
    String passwordExist = "Password123";
    String emailExist = "user@email.com";

    @Test
    void successfulRegistration() throws InterruptedException {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage.clickOnRegistrationButton();
        registrationPage.registerUser(username, password, email);
        assertThat(driver.getCurrentUrl())
                .contains("login");
    }
    @Test
    void unSuccessfulRegistration() throws InterruptedException {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage.clickOnRegistrationButton();
        registrationPage.registerUser(usernameExist, passwordExist, emailExist);
        String errMessage = registrationPage.getErrorMessage();
        assertThat(errMessage)
                .contains("Username is already taken.");
    }
}
