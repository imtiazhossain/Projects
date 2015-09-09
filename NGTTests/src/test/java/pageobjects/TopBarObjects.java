package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbaseframework.HelperClass;

/**
 * Created by ihossain on 7/9/2015.
 */
public class TopBarObjects extends HelperClass {

    public String loansText, borrowsText;

    public static void clickUploadButton() {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@class, 'upload-securities-btn')]"));
        button.click();
    }

//    public static void clickUserMenu() {
//        WebElement button = getWhenVisible(By.xpath("//a[contains(@class, 'user-config-btn')]"));
//        button.click();
//    }

    public static void clickLogoutButton() {
        WebElement button = getWhenVisible(By.xpath("//a[contains(@class, 'user-config-btn')]"));
        button.click();
        element = getWhenVisible(By.xpath("//span[text()='Logout']"));
        element.click();
    }

    public static void logout() {
//        clickUserMenu();
        clickLogoutButton();
    }

    public WebElement navMenuBtn() {
        HelperClass.element = getWhenVisible(By.cssSelector("span[id*='navMenuBtn']"));
        return HelperClass.element;
    }

    public WebElement borrowsLoansSlider() {
        HelperClass.element = getWhenVisible(By.className("holder"));
        return HelperClass.element;
    }

    //CSS
//    public void clickUploadButton() {
//        WebElement button = getWhenVisible(By.cssSelector(".x-toolbar .upload-securities-btn"));
//        button.click();
//    }

    public void getLoansText() {
        loansText = getWhenVisible(By.className("x-toggle-slide-label-off")).getText();
    }

    public void getBorrowsText() {
        borrowsText = getWhenVisible(By.className("x-toggle-slide-label-on")).getText();
    }

    public void searchSecurityField(String input) {
        WebElement field = getWhenVisible(By.id("textfield-1017-inputEl"));
        field.sendKeys(input);
    }

    public void clickSearchSecurityXButton() {
        WebElement button = getWhenVisible(By.id("button-1018-btnIconEl"));
        button.click();
    }

    public void clickProfileButton() {
        WebElement button = getWhenVisible(By.cssSelector(".profile-setting-btn"));
        button.click();
    }
}
