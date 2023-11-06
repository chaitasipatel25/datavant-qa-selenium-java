package org.example.tests;

import org.example.base.TestBase;
import org.example.pages.TicketOfficePage;
import org.example.pages.TrainSearchPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrainSearchTest extends TestBase {

    TrainSearchPage trainSearchPage;
    TicketOfficePage ticketOfficePage;

    public TrainSearchTest(){
        super();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initializaton();
        trainSearchPage = new TrainSearchPage();
        ticketOfficePage = new TicketOfficePage();
    }

    @DataProvider(name = "data-provider")
    public static Object [] [] dataProviderMethod () {
        return new Object[][] { { "Lagos", "Porto - Campanha", 3, 5 },
                                { "Lagos", "Porto - Campanha", 30, 35 },
                                { "Ameal", "Juncal", 1, 40 },
                                { "Juncal", "Lapa", 8, 8 }
        };
    }

    @Test(dataProvider = "data-provider")
    public void submitSearch(String from, String to, int departDays, int returnDays) {
        trainSearchPage.verifyTrainSearchPage();
        trainSearchPage.requestOnlineTicket(from, to, departDays, returnDays);
        ticketOfficePage.verifyTicketOfficePage();
        ticketOfficePage.cancelRequest();
    }

    @AfterSuite
    public void tearDown(){
        tearDownMain();
    }
}
