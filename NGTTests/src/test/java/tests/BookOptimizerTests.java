package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BookOptimizerObjects;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by ihossain on 7/9/2015.
 */
@Features("Book Optimizer")
public class BookOptimizerTests extends BookOptimizerObjects {

    @Test
    @Stories("User inputs list of securities into book optimizer")
    public void inputSecuritiesInBookOptimizer() {
        testStep = "Paste list of securities";
            boSecField().sendKeys("STEM 10,000 6.5\n" +
                "STON 10,000 14.5\n" +
                "STXS 10,000 7.5\n" +
                "SWHC 10,000 0.5\n" +
                "TAHO 10,000 0.5\n" +
                "TBPH 10,000 1.25\n");
        loadingTimeout();
        testStep = "Click clear all button";
            clearAllLink().click();
        testStep = "Click yes button on message";
            yesButton().click();
    }

    @Test
    @Stories("Verify Book Optimizer Columns")
    public void verifyBookOptColumns() {
        loadingTimeout();
        testStep = "Get SecIDCol text from page";
            text = boSecIDCol().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Sec ID");

        testStep = "Get QtyCol text from page";
            text = boQtyCol().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Qty");

        testStep = "Get BidCol text from page";
            text = boBidCol().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Bid");

        testStep = "Get AvgBorrowRate text from page";
            text = boAvgBorrowRate().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Avg Borrow Rate");

        testStep = "Get DataLendRate text from page";
            text = boDataLendRate().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "DataLend Rate");

        testStep = "Get SentCpty text from page";
            text = boSentCpty().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Sent Cpty");

        testStep = "Get MatchedInventory text from page";
            text = boMatchedInventory().getText();
        testStep = "Assert that the text from page is expected";
            Assert.assertEquals(text, "Matched Inventory");
    }
}
