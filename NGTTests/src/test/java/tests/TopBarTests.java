package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TopBarObjects;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by ihossain on 7/9/2015.
 */
@Features("Top Bar")
public class TopBarTests extends TopBarObjects {

    @Test
    @Stories("User clicks on navigation logo")
    public void clickNavMenuBtn() {
        navMenuBtn().click();
    }

    @Test
    @Stories("User clicks on borrow/loans slider")
    public void verifyBorrowsLoanSlider() {
        testStep = "click on borrow/loan slider";
            borrowsLoansSlider().click();
        loadingTimeout();
        testStep = "verify that text shows as Loans";
            getLoansText();
            Assert.assertEquals(loansText, "Loans");

        testStep = "click on borrow/loan slider again";
            borrowsLoansSlider().click();
        loadingTimeout();
        testStep = "verify that the slider now shows as Borrows";
            getBorrowsText();
            Assert.assertEquals(borrowsText, "Borrows");
    }

    @Test
    @Stories("User inputs security into the security search filter")
    public void verifySearchSecurityXButton() {
        testStep = "input security into search field";
            searchSecurityField("aapl");
        testStep = "clear security search";
            clickSearchSecurityXButton();
    }
}
