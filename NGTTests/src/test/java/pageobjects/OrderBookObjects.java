package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ihossain on 7/12/2015.
 */
public class OrderBookObjects extends TraderProfileSettingsObjects {

    public WebElement listViewButton() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'radiopushbuttons')]//a[contains(@class, 'rpbtn-first')]"));
        return element;
    }

    public WebElement securityViewButton() {
        element = getWhenVisible(By.xpath("//div[contains(@class, 'rpbtn-cont')][1]//a[2]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement bookOptimizerButton() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'radiopushbuttons')]//a[contains(@class, 'rpbtn-last')]"));
        return element;
    }

    public WebElement mostRcntOrdrLstView() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'batchGrid')]//div[contains(@class, 'x-grid-view')]//tr[1]/td[1]/div"));
        return element;
    }

    public WebElement mostRcntOrdrSecView() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[1]/td[1]/div"));
        return element;
    }

    public WebElement acceptAllBtn() {
        element = getWhenVisible(By.xpath("//span[contains(@class, 'arc-header-AC')]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement actionRequiredBtn() {
        element = getWhenVisible(By.xpath("//div[contains(@class, 'rpbtn-cont')][2]//a[2]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement acceptAll() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//*[contains(@class, 'x-grid-header-ct')]//span[contains(@class, 'arc-header-AC')]"));
        Actions actions = new Actions(driver());
        actions.moveToElement(element);
// actions.click();
        actions.perform();
        actions.click();
        return element;
    }

    public WebElement firstCollCCY() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[1]/td[17]/div"));
        return element;
    }

    public void firstCollCCYInput(String value) {
        firstCollCCY().click();
        WebElement input = getWhenVisible(By.xpath("//input[contains(@class, 'x-field-default-form-focus')]"));
        input.sendKeys(value);
        input.sendKeys(Keys.TAB);
        Actions actions = new Actions(driver());
        actions.sendKeys(Keys.TAB).perform();
    }

    public void firstCollCCYApplyAll() {
        Actions action = new Actions(driver());
        action.contextClick(firstCollCCY()).perform();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-menu-item-text')]")).click();
    }

    public WebElement firstSettType() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[1]/td[19]"));
        return element;
    }

    public void firstSettTypeInput(String value) {
//        WebElement input = getWhenVisible(By.xpath("//input[contains(@class, 'x-field-default-form-focus')]"));
        Actions actions = new Actions(driver());
        actions.sendKeys(value);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
    }

    public void firstSettTypeApplyAll() {
        Actions action = new Actions(driver());
        action.contextClick(firstSettType()).perform();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-menu-item-text')]")).click();
    }

    public WebElement firstBillingCCY() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[1]/td[23]"));
        return element;
    }

    public void firstBillingCCYInput(String value) {
//        WebElement input = getWhenVisible(By.xpath("//input[contains(@class, 'x-field-default-form-focus')]"));
        Actions actions = new Actions(driver());
        actions.sendKeys(value);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
    }

    public void firstBillingCCYApplyAll() {
        Actions action = new Actions(driver());
        action.contextClick(firstBillingCCY()).perform();
        getWhenVisible(By.xpath("//*[contains(@class, 'x-menu-item-text')]")).click();
    }

    public WebElement firstSecBid() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[1]/td[26]//img[1]"));
        return element;
    }

    public WebElement secondSecRej() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[2]/td[26]//img[2]"));
        return element;
    }

    public WebElement thirdSecBid() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[3]/td[26]//img[1]"));
        return element;
    }

    public WebElement fourthSecRej() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[4]/td[26]//img[2]"));
        return element;
    }

    public WebElement fifthSecBid() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[5]/td[26]//img[1]"));
        return element;
    }

    public WebElement sixthSecRej() {
        element = getWhenVisible(By.xpath("//div[contains(@id, 'negotiationsGrid')]//tbody[contains(@id, 'gridview')]/tr[6]/td[26]//img[2]"));
        return element;
    }

    public WebElement submitAllBtn() {
//        element = getWhenVisible(By.xpath("//a[contains(@class, 'order-submit-all')]"));
        element = getWhenVisible(By.xpath("//td[contains(@class, 'order-submit-active')]"));
//        Actions actions = new Actions(driver());
//        actions.clickAndHold(element).perform();
//        actions.release().perform();
        return element;
    }

}
