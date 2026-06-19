import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class searchTest extends BaseTest{
    LoginPage loginPage;
    CalculatorPage calculatorPage;
    CalculationPage calculationPage;

    String username = "user";
    String password = "Password123";
    String firstNumber = "1";
    String secondNumber = "1";
    String firstNegativeNumber = "0";
    String secondNegativeNumber = "0";

    @Test
    void searchPositiveTest() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);
        calculationPage = new CalculationPage(driver);

        loginPage.loginUser(username, password);
        Thread.sleep(2000);
        calculatorPage.calculate(firstNumber, secondNumber);
        Thread.sleep(2000);
        calculationPage.clickCalculationButton();

        String firstNumFromList = calculationPage.getFirstNumber();
        String secondNumFromList = calculationPage.getSecondNumber();
        String usernameFromList = calculationPage.getUserName();

        //Check first number
        assertThat(firstNumFromList).isEqualTo(firstNumber);
        //Check second number
        assertThat(secondNumFromList).isEqualTo(secondNumber);
        // Check username
        assertThat(usernameFromList).isEqualTo(username);

    }
    @Test
    void searchNegativeTest() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);
        calculationPage = new CalculationPage(driver);

        loginPage.loginUser(username, password);
        Thread.sleep(2000);
        calculatorPage.clickDivision();
        calculatorPage.calculate(firstNegativeNumber, secondNegativeNumber);
        Thread.sleep(2000);
        calculationPage.clickCalculationButton();

        //Check that in the table 0 rows with data
        int rowsCount = calculationPage.getRowsCount();
        assertThat(rowsCount)
                .as("Table should be empty for incorrect data")
                .isEqualTo(0);

    }
}
