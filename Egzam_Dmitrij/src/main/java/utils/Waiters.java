package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static void waitForElemVisibility(WebDriver driver, WebElement pageWebElement, Duration timeout){
        new WebDriverWait(driver, timeout)
                //Helps if the element disappears and reappears (due to re-rendering).
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(pageWebElement));
    }

    public static void waitForElementIsClickable(WebDriver driver, WebElement pageWebElement, Duration timeout){
        new WebDriverWait(driver, timeout)
                //Helps if the element disappears and reappears (due to re-rendering).
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(pageWebElement));
    }
}