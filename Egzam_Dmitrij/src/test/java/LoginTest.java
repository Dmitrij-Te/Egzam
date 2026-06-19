import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest{

    LoginPage loginPage;

    String username = "user";
    String password = "Password123";

    String invalidUsername = "baduser";
    String invalidPassword = "badpass";


    @Test
    void successfulLogin() {
        loginPage = new LoginPage(driver);

        loginPage.loginUser(username, password);

        assertThat(driver.getCurrentUrl())
                .contains("calculator");
    }

    @Test
    void unSuccessfulLogin() {
        loginPage = new LoginPage(driver);

        loginPage.loginUser(invalidUsername, invalidPassword);

        String errMessage = loginPage.getErrorMessage();
        assertThat(errMessage)
                .contains("Invalid username or password.");
    }
}
