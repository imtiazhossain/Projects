package tests;

import org.testng.annotations.Test;
import pageobjects.SecuritiesUpload;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static pageobjects.TopBarObjects.clickUploadButton;

/**
 * Created by ihossain on 7/14/2015.
 */
@Features("Securities Requested")
public class FileUploadTests extends SecuritiesUpload {

    @Test
    @Stories("Borrower uploads an excel and send to lender")
    public void uploadFile() throws Exception {
        testStep = "click upload button in top bar";
            clickUploadButton();
        testStep = "enter receiving party";
            sendTo(lender);
        testStep = "click firm request checkbox";
            clickFirmRequestCheckbox();
        testStep = "click choose file button";
            clickChooseFileButton();
        loadingTimeout();
        testStep = "upload a file \\EQNYC-IH\\NGTTests\\src\\NgtFirmRequest_1.xls";
            uploadAFile();
        loadingTimeout();
        testStep = "click send";
            clickSendButton();
            clickOKButton();
    }
}
