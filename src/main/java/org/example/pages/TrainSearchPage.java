package org.example.pages;

import org.example.base.TestBase;
import org.example.utilities.SeleniumAction;
import org.example.utilities.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.logging.Logger;

public class TrainSearchPage extends TestBase {

    private static final Logger LOGGER = Logger.getLogger( TrainSearchPage.class.getName() );
    SeleniumAction seleniumAction = new SeleniumAction();
    TestUtils testUtils = new TestUtils();

    @FindBy(css = ".navbar-brand")
    private WebElement navBar;
    @FindBy(name = "textBoxPartida")
    private WebElement fromInput;

    @FindBy(id = "arrival-date")
    private WebElement toInput;

    @FindBy(id = "datepicker-first" )
    private WebElement fromDatePicker;

    @FindBy(id = "datepicker-second" )
    private WebElement toDatePicker;

    @FindBy(xpath = "//input[@type='submit']")
    private  WebElement submitButton;

    public TrainSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyTrainSearchPage() {
        seleniumAction.waitUntilElementVisible(driver, 10, navBar);
    }
    public void requestOnlineTicket(String from, String to, int departDays, int returnDays) {
        fromInput.clear();
        fromInput.sendKeys(from);
        fromInput.sendKeys(Keys.TAB);
        toInput.clear();
        toInput.sendKeys(to);
        toInput.sendKeys(Keys.TAB);
        fromDatePicker.clear();
        selectDate(departDays, "first");
        fromDatePicker.sendKeys(Keys.TAB);
        toDatePicker.clear();
        selectDate(returnDays, "second");
        seleniumAction.waitUntilElementVisible(driver, 10, submitButton);
        submitButton.click();
    }

    public void selectDate(int days, String type) {
        String month = testUtils.getMonth(days);
        String day = testUtils.getDay(days);
        String logMsg = String.format("Selecting %s of %s", day, month);
        LOGGER.info(logMsg);
        chooseDate(month, type, day);
    }
    public void chooseDate(String month_year, String type, String select_day) {
        String pickMonthXpath  = "//div[@id='datepicker-"+type+"_root']//div[@class='picker__month']";
        String pickMonth = driver.findElement(By.xpath(pickMonthXpath)).getAttribute("innerText");
        if (!pickMonth.equals(month_year)) {
            LOGGER.info("Navigating to next month");
            String nextMonthXpath  = "//div[@id='datepicker-"+type+"_root']//div[@class='picker__nav--next']";
            driver.findElement(By.xpath(nextMonthXpath)).click();
        }
        Assert.assertEquals(driver.findElement(By.xpath(pickMonthXpath)).getAttribute("innerText"), month_year);
        String dayXpath  = "//table[@id='datepicker-"+type+"_table']/tbody/tr/td[normalize-space()='"+select_day+"']";
        driver.findElement(By.xpath(dayXpath)).click();
    }
}
