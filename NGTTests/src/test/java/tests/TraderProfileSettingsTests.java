package tests;

import org.testng.annotations.Test;
import pageobjects.TopBarObjects;
import pageobjects.TraderProfileSettingsObjects;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by ihossain on 7/10/2015.
 */
@Features("Trader Profile")
public class TraderProfileSettingsTests extends TraderProfileSettingsObjects {

    TopBarObjects topBarObjects = new TopBarObjects();

    @Test
    @Stories("Open trader profile settings")
    public void openTraderProfileSettings() {
        testStep = "click profile button";
            topBarObjects.clickProfileButton();
        testStep = "close profile menuu";
            clickXButton();
    }
}
