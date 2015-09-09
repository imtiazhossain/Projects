package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OrderBookObjects;
import pageobjects.SecuritiesUpload;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static pageobjects.TopBarObjects.clickUploadButton;
import static pageobjects.TopBarObjects.logout;

/**
 * Created by ihossain on 7/17/2015.
 */
@Features("Borrow/Lender Messaging")
public class BorrowerLenderTests extends SecuritiesUpload {

    OrderBookObjects orderBookObjects = new OrderBookObjects();

    @Test
    @Stories("Borrower pastes a list of securities via upload and sends to Lender")
    public void sendMessageAndVerify() {
        testStep = "click upload button in top bar";
            clickUploadButton();
        testStep = "enter receiving party";
            sendTo(lender);
        testStep = "paste securities";
            securitiesField().sendKeys("STEM 10,000 6.5\n");
            securitiesField().sendKeys("STON 10,000 14.5\n");
            securitiesField().sendKeys("STXS 10,000 7.5\n");
            securitiesField().sendKeys("SWHC 10,000 0.5\n");
            securitiesField().sendKeys("TAHO 10,000 0.5\n");
            securitiesField().sendKeys("TBPH 10,000 1.25\n");
        loadingTimeout();
        testStep = "select CA collateral type";
            collTypeDropdown();
        loadingTimeout();
            selectCACollType();
        testStep = "coll type apply all";
            collTypeApplyAll();
        loadingTimeout();
        testStep = "click send";
            clickSendButton();

        loadingTimeout();
            logout();
        testStep = "log in as lender";
            lenderLogin();

        loadingTimeout();
        testStep = "verify that the message was received";
            String text = orderBookObjects.mostRcntOrdrLstView().getText();
            Assert.assertEquals(text, "< 1 min ago");
    }
}
