package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OrderBookObjects;
import pageobjects.SecuritiesUpload;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static pageobjects.TopBarObjects.clickUploadButton;
import static pageobjects.TopBarObjects.logout;

@Features("Borrow/Lender Messaging")
public class LenderBorrowTests extends SecuritiesUpload {

    OrderBookObjects orderBookObjects = new OrderBookObjects();

    @Test
    @Stories("Lender sends Targeted Availability")
    @TestCaseId("https://eql.qtestnet.com/p/4897/portal/project#id=1042254&object=1&tab=testdesign")
    public void lenderTgtAvail() {
            logout();
        testStep = "Lender logs into NGT";
            lenderLogin();
        testStep = "Lender Clicks on the Upload button on the right hand side";
            clickUploadButton();
        testStep = "Lender selects recipient(s)";
            sendTo(borrower);
        testStep = "Lender pastes list of securities";
            securitiesField().sendKeys("STEM 10,000 6.5\n");
            securitiesField().sendKeys("STON 10,000 14.5\n");
            securitiesField().sendKeys("STXS 10,000 7.5\n");
            securitiesField().sendKeys("SWHC 10,000 0.5\n");
            securitiesField().sendKeys("TAHO 10,000 0.5\n");
            securitiesField().sendKeys("TBPH 10,000 1.25\n");
        testStep = "Lender selected cash collateral type for all";
        loadingTimeout();
            collTypeDropdownLender();
        loadingTimeout();
            selectCACollType();
            collTypeApplyAllLender();
        loadingTimeout();
        testStep = "Lender sends securities";
            clickSendButton();
        loadingTimeout();
        testStep = "Verify that the order was sent < 1 min ago";
            String text = orderBookObjects.mostRcntOrdrLstView().getText();
            Assert.assertEquals(text, "< 1 min ago");
        testStep = "Click on Security View";
            orderBookObjects.securityViewButton().click();
        testStep = "Verify that the order was sent By me < 1 min ago";
            String textTwo = orderBookObjects.mostRcntOrdrSecView().getText();
            Assert.assertEquals(textTwo, "By me < 1 min ago");
    }

//    @Test(dependsOnMethods = {"lenderTgtAvail"})
//    @Stories("Borrower responds to TA")
//    @TestCaseId("https://eql.qtestnet.com/p/4897/portal/project#id=1042260&object=1&tab=testdesign")
//    public void borrowerResponseToTA() {
//        logout();
//        sleep(2000);
//        borrowerLogin();
//        orderBookObjects.actionRequiredBtn().click();
//        orderBookObjects.acceptAll().click();
////        orderBookObjects.firstSecBid().click();
////        orderBookObjects.firstCollCCYInput("GBP");
////        sleep(1000);
////        orderBookObjects.firstSettTypeInput("EUR");
////        sleep(1000);
////        orderBookObjects.firstBillingCCY("USD");
////
////        sleep(500);
////        orderBookObjects.secondSecRej().click();
////        sleep(500);
////        orderBookObjects.thirdSecBid().click();
////        sleep(500);
////        orderBookObjects.fourthSecRej().click();
////        sleep(500);
////        orderBookObjects.fifthSecBid().click();
////        sleep(500);
////        orderBookObjects.sixthSecRej().click();
////        sleep(500);
//        orderBookObjects.submitAllBtn().click();
//    }

    //    @Test(dependsOnMethods = ("borrowerResponseToTA"))
//    @Stories("Borrower reponds to the Bid") @TestCaseId("https://eql.qtestnet.com/p/4897/portal/project#tab=testdesign&object=1&id=1042304")
//    public void borrowerResponseToBid() {
//
//    }
//
//    @Test
//    public void test() {
//        orderBookObjects.actionRequiredBtn().click();
//
//        orderBookObjects.firstCollCCYInput("GBP");
//        sleep(1000);
//        orderBookObjects.firstSettTypeInput("EUR");
//        sleep(1000);
//        orderBookObjects.firstBillingCCYInput("USD");
//
////        orderBookObjects.acceptAll().click();
////        orderBookObjects.firstCollCCYApplyAll();
////        orderBookObjects.firstSettTypeApplyAll();
////        orderBookObjects.firstBillingCCYApplyAll();
//        orderBookObjects.submitAllBtn().click();
//        sleep(10000);
//    }
}
