package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbaseframework.HelperClass;

/**
 * Created by ihossain on 7/6/2015.
 */
public class BookOptimizerObjects extends MainObjects {

    //**
    //**Book Optimizer objects
    //**

    public WebElement boSecField() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//textarea"));
        return element;
    }

    public WebElement clearAllLink() {
        element = getWhenVisible(By.xpath("//*[contains(@class, 'linkButton')]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement yesButton() {
        element = getWhenVisible(By.linkText("Yes"));
        return element;
    }

    public WebElement noButton() {
        element = getWhenVisible(By.linkText("No"));
        return element;
    }

    public WebElement boSecIDCol() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[2]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement boQtyCol() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[3]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement boBidCol() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[4]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement boAvgBorrowRate() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[5]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement boDataLendRate() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[6]"));
        scrollElementIntoView();
        return HelperClass.element;
    }

    public WebElement boSentCpty() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[7]"));
        scrollElementIntoView();
        return HelperClass.element;
    }

    public WebElement boMatchedInventory() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@id, 'headercontainer')]//*[contains(@class, 'x-box-target')]/div[11]"));
        scrollElementIntoView();
        return element;
    }

    public WebElement optimizerSplitter() {
        element = getWhenVisible(By.cssSelector("div[id*='bookOpt'] + div[id*='splitter']"));
        return element;
    }

    public WebElement optimizerOpenCloseBtn() {
        element = getWhenVisible(By.xpath("//*[contains(@id, 'bookOpt')]//*[contains(@class, 'x-tool-pressed')]"));
        return element;
    }

    public void dragOptSplitter() {
        Actions action = new Actions(driver());
        action.clickAndHold(optimizerSplitter());
        action.dragAndDropBy(optimizerSplitter(), 1000, 0);
        action.release();
        action.perform();
    }

}
