package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by ihossain on 7/10/2015.
 */
public class TraderProfileSettingsObjects extends SecuritiesUpload {

    public void clickXButton() {
        WebElement button = getWhenVisible(By.xpath("//div[contains(@class, 'x-window-closable')]//div[contains(@class, 'x-tool-after-title')]"));
        button.click();
    }
}
