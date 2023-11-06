package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumAction {

    public void waitUntilElementVisible(WebDriver driver, int timeout, WebElement element){
        WebDriverWait w =  new WebDriverWait(driver, Duration.ofMillis(timeout) );
        w.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementToBeClickable(WebDriver driver, int timeout, WebElement element){
        WebDriverWait w =  new WebDriverWait(driver, Duration.ofMillis(timeout) );
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementToBeClickable(WebDriver driver, int timeout, By element){
        WebDriverWait w =  new WebDriverWait(driver, Duration.ofMillis(timeout) );
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void selectbyText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectbyValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
