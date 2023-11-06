package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class TicketOfficePage extends TestBase {

    @FindBy(id = "exitButton" )
    private WebElement exitButton;

    @FindBy(xpath = "//h1" )
    private WebElement pageHeader;

    public TicketOfficePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyTicketOfficePage() {
        Assert.assertEquals(pageHeader.getText(), "Online Ticket Office");
    }
    public void cancelRequest() {
        exitButton.click();
    }
}

