package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OrderBookObjects;
import pageobjects.SecuritiesUpload;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.awt.*;

import static pageobjects.TopBarObjects.clickUploadButton;
import static pageobjects.TopBarObjects.logout;

/**
 * Created by ihossain on 8/7/2015.
 */
@Features("Legacy Upload")
public class LegacyUpload extends SecuritiesUpload {

    OrderBookObjects orderBookObjects = new OrderBookObjects();

    @Test
    @Stories("Borrower sends list of securities through Legacy tab in upload") @TestCaseId("https://eql.qtestnet.com/p/4897/portal/project#tab=testdesign&object=1&id=1220506")
    public void sendListOfSecurities() throws InterruptedException, AWTException {
        testStep = "click upload button in top bar";
            clickUploadButton();
        testStep = "click Legacy tab";
            clickLegacyTab();
        loadingTimeout();
        testStep = "select a schedule";
            scheduleField().click();
            scheduleField().sendKeys(Keys.ARROW_DOWN);
            scheduleField().sendKeys(Keys.ENTER);
        loadingTimeout();
        testStep = "click Choose File button";
            legacyChooseFile();
        loadingTimeout();
        testStep = "upload an excel located on Y:\\Equilend Shared\\QA\\NGT\\ABX UPLOAD_IH";
            uploadABXFile();
        loadingTimeout();
        testStep = "click send button";
            legacySend().click();
            clickOKButton();
    }

    @Test(dependsOnMethods = {"sendListOfSecurities"})
    @Stories("Lender responds to message sent by borrower through Legacy upload") @TestCaseId("https://eql.qtestnet.com/p/4897/portal/project#tab=testdesign&object=1&id=1220506")
    public void lenderReponseToLegacyOrd() {
            logout();
        testStep = "log in as lender";
            lenderLogin();
        loadingTimeout();
        testStep = "Verify that the order was sent < 1 min ago";
            String text = orderBookObjects.mostRcntOrdrLstView().getText();
            Assert.assertEquals(text, "< 1 min ago");
    }
}
