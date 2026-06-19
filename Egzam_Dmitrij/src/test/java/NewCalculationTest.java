import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewCalculationTest extends BaseTest{
    LoginPage loginPage;
    CalculatorPage calculatorPage;

    String username = "user";
    String password = "Password123";
    String firstNumber = "1";
    String secondNumber = "1";
    int total = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
    String firstNegativeNumber = "0";
    String secondNegativeNumber = "0";




    @Test
    void newCalculationPositive() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.loginUser(username, password);

        calculatorPage.calculate(firstNumber, secondNumber);
        Thread.sleep(2000);
        String calcResult = calculatorPage.getResult();
        assertThat(calcResult)
                .contains(firstNumber + " + " +  secondNumber + " = " + total);
    }

    @Test
    void newCalculationNegative() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.loginUser(username, password);
        Thread.sleep(2000);
        calculatorPage.clickDivision();
        calculatorPage.calculate(firstNegativeNumber, secondNegativeNumber);
        Thread.sleep(2000);
        String calcResult = calculatorPage.getErrMessage();
        assertThat(calcResult)
                .contains("Cannot divide by zero");
    }


}
