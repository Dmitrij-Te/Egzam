import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EditTest extends BaseTest{
    LoginPage loginPage;
    CalculatorPage calculatorPage;
    CalculationPage calculationPage;
    EditPage editPagePage;
    ShowPage showPage;

    String username = "user";
    String password = "Password123";
    String firstNumber = "1";
    String secondNumber = "1";
    String newFirstNumber = "5";
    String newSecondNumber = "5";

    @Test
    void searchPositiveTest() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);
        calculationPage = new CalculationPage(driver);
        editPagePage = new EditPage(driver);
        showPage = new ShowPage(driver);

        loginPage.loginUser(username, password);
        Thread.sleep(2000);
        calculatorPage.calculate(firstNumber, secondNumber);
        Thread.sleep(2000);
        calculationPage.clickCalculationButton();

        editPagePage.clickFirstEdit();
        Thread.sleep(2000);
        editPagePage.changeData(newFirstNumber, newSecondNumber);
        Thread.sleep(2000);

        String NumberFirstFromShow = showPage.getFirstNumberValue();
        String NumberSecondFromShow = showPage.getSecondNumberValue();

        assertThat(NumberFirstFromShow).isEqualTo(newFirstNumber);
        assertThat(NumberSecondFromShow).isEqualTo(newSecondNumber);
    }

    @Test
    void operationNegativeTest() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);
        calculationPage = new CalculationPage(driver);
        editPagePage = new EditPage(driver);
        showPage = new ShowPage(driver);

        loginPage.loginUser(username, password);
        Thread.sleep(2000);
        calculatorPage.calculate(firstNumber, secondNumber);
        Thread.sleep(2000);
        calculationPage.clickCalculationButton();

        editPagePage.clickFirstEdit();

        editPagePage.changeOperation("5");

        String actualError = editPagePage.getOperationErrorMessage();

        assertThat(actualError)
                .as("Error message")
                .isEqualTo("Please enter only one of the following symbols: +, -, *, /");
    }

}
