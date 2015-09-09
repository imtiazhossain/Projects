package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbaseframework.HelperClass;

/**
 * Created by ihossain on 6/30/2015.
 */
public class MainObjects extends HelperClass {

    public static String borrower = "ihborrower";
    public static String lender = "ihlender";

    public static WebElement usernameField() {
        element = getWhenVisible(By.id("USER"));
        return element;
    }

    public static WebElement passwordField() {
        element = getWhenVisible(By.id("PASSWORD"));
        return element;
    }

    public static void login(String username, String password) {
        usernameField().clear();
        usernameField().sendKeys(username);
        passwordField().click();
        passwordField().clear();
        passwordField().sendKeys(password);
        clickLoginButton();
    }

    public static void borrowerLogin() {
        login(borrower, "asdf1234");
        selectNGT();
    }

    public static void lenderLogin() {
        login(lender, "asdf1234");
        selectNGT();
    }

    public static void clickLoginButton() {
        WebElement button = getWhenVisible(By.id("loginBtDiv"));
        button.click();
    }

    public static void hoverOverTradingInMenu() {
        WebElement button = getWhenVisible(By.xpath("//*[contains(@id, 'main1')]"));
        Actions action = new Actions(driver());
        action.moveToElement(button).build().perform();
    }

    public static void selectNGT() {
        hoverOverTradingInMenu();
        WebElement locator = getWhenVisible(By.xpath("//a[text()='NGT']"));
        locator.click();
    }
}
