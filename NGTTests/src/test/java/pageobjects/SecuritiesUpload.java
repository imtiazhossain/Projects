package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by ihossain on 7/9/2015.
 */
public class SecuritiesUpload extends BookOptimizerObjects {

    public static WebElement uploadXButton() {
        element = getWhenVisible(By.cssSelector(".x-tool-close"));
        return element;
    }

    public void sendTo(String user) {
        WebElement field = getWhenVisible(By.xpath("//input[@name = 'ctpyDesks']"));
        field.click();
        field.sendKeys(user);
        sleep(1000);
//        field.sendKeys(Keys.ARROW_DOWN);
        field.sendKeys(Keys.TAB);
    }

    public void clickFirmRequestCheckbox() {
        getWhenVisible(By.cssSelector(".x-window-body input[id*='checkbox']")).click();
    }

    public void clickChooseFileButton() throws AWTException {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@id, 'fileuploadfield')]//span[contains(@class, 'x-btn-wrap')]"));
        Actions action = new Actions(driver());
        action.clickAndHold(button);
        action.sendKeys(button, Keys.SPACE);
        action.perform();
    }

    public void uploadAFile() throws AWTException, InterruptedException {
        StringSelection ss = new StringSelection("\\" + "\\EQNYC-IH\\NGTTests\\src\\NgtFirmRequest_1.xls");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //CSS
//    public void inputSecuritiesField(String securities) {
//        WebElement field = driver.findElement(By.cssSelector(".x-window-body textarea[id*='securityDropZone']"));
//        field.sendKeys(securities);
//    }

//    public void inputSecuritiesField(String securities) {
//        WebElement field = getWhenVisible(By.xpath("//div[contains(@class, 'x-window-closable')] //textarea[contains(@id, 'securityDropZone')]"));
//        field.sendKeys(securities);
//    }

    public WebElement securitiesField() {
        element = getWhenVisible(By.xpath("//div[contains(@class, 'x-window-closable')] //textarea[contains(@id, 'securityDropZone')]"));
        return element;
    }

    //    public void collTypeDropdown() {
//        WebElement dropdown = driver.findElement(By.cssSelector(".x-window-body .x-grid-row td:nth-of-type(6)"));
//        dropdown.click();
//        driver.findElement(By.cssSelector("div[id*='uploadNeedsGrid'] .x-form-arrow-trigger")).click();
//    }

    public void collTypeDropdown() {
        WebElement dropdown = getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//tr[1]/td[7]"));
        dropdown.click();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//*[contains(@class, 'x-grid-view')]//*[contains(@class, 'x-form-arrow-trigger')]")).click();
    }

    public void collTypeDropdownLender() {
        WebElement dropdown = getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//tr[1]/td[7]"));
        dropdown.click();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//*[contains(@class, 'x-grid-view')]//*[contains(@class, 'x-form-arrow-trigger')]")).click();
    }

    public void selectCACollType() {
        Actions action = new Actions(driver());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    public void collTypeApplyAll() {
        WebElement cell = getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//tr[1]/td[7]"));
        Actions action = new Actions(driver());
        action.contextClick(cell).perform();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-menu-item-text')]")).click();
    }

    public void collTypeApplyAllLender() {
        WebElement cell = getWhenVisible(By.xpath("//*[contains(@class, 'x-window-closable')]//tr[1]/td[7]"));
        Actions action = new Actions(driver());
        action.contextClick(cell).build().perform();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-menu-item-text')]")).click();
    }

    public void clickSendButton() {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@class, 'x-window-body')]//*[contains(@class, 'x-btn-button')]"));
        button.click();
    }

    public void clickOKButton() {
        getWhenVisible(By.linkText("OK")).click();
    }

    public void clickLegacyTab() {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@id, 'btnWrap')]//*[contains(@class, 'x-tab-button')]//*[contains(., 'Legacy')]"));
        button.click();
    }

    public WebElement legacyChooseFile() {
        element = getWhenVisible(By.xpath("//span[contains(@id, 'legacyUploadForm')]//span[text()='Choose File']"));
        Actions action = new Actions(driver());
        action.clickAndHold(element);
        action.sendKeys(element, Keys.SPACE);
        action.perform();
        return element;
    }

    public WebElement scheduleField() {
        element = getWhenVisible(By.name("schedChainId"));
        return element;
    }

    public void uploadABXFile() throws AWTException, InterruptedException {
        StringSelection ss = new StringSelection("Y:\\Equilend Shared\\QA\\NGT\\ABX UPLOAD_IH");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public WebElement legacySend() {
        element = getWhenVisible(By.xpath("//span[contains(@id, 'legacyUploadForm')]//*[text()='Send']"));
        return element;
    }

    public void clickDistListsTab() {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@id, 'btnWrap')]//*[contains(@class, 'x-tab-button')]//*[contains(., 'Distribution Lists')]"));
        button.click();
    }
}
