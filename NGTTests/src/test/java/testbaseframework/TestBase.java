package testbaseframework;

import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static pageobjects.MainObjects.borrowerLogin;
import static pageobjects.TopBarObjects.logout;

/**
 * Created by ihossain on 6/30/2015.
 */
public class TestBase {

    protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
    public String hubURL;

    //Return driver with properties set above
    public static WebDriver driver() {
        return threadDriver.get();
    }

//    @Parameters("browser")

    @BeforeClass
//    public void setUp(String browser) throws MalformedURLException {
    public void setUp() throws MalformedURLException {
        threadDriver = new ThreadLocal<RemoteWebDriver>();
        //selenium hub url
        hubURL = "http://172.16.1.88:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

//        if (browser.equalsIgnoreCase("IE7")) {
//            capabilities.setBrowserName("internet explorer");
//            capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setVersion("7.0");
//
//        } else if (browser.equals("IE8")) {
//            capabilities.setBrowserName("internet explorer");
//            capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setVersion("8.0");
//
//        } else if (browser.equals("IE9")) {
        capabilities.setBrowserName("internet explorer");
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setVersion("9.0");
//
//        } else if (browser.equals("IE10")) {
//            capabilities.setBrowserName("internet explorer");
//            capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setVersion("10.0");
////
//        } else if (browser.equals("IE11")) {
//            capabilities.setBrowserName("internet explorer");
//            capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setVersion("11.0");
//
//        } else if (browser.equals("Firefox")) {
//            capabilities.setBrowserName("firefox");
//            capabilities.setPlatform(Platform.WINDOWS);
//
//        } else if (browser.equals("Chrome")) {
//            capabilities.setBrowserName("chrome");
//            capabilities.setPlatform(Platform.WINDOWS);
//        }

        //Change browser settings here
        threadDriver.set(new RemoteWebDriver(new URL(hubURL), capabilities));
        //Browser settings
        threadDriver.get().manage().window().setPosition(new Point(0, 0));
        threadDriver.get().manage().window().setSize(new Dimension(1200, 1080));
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        driver().get(System.getProperty("webdriver.base.url"));
//        driver().get("https://qa.equilend.com/el/common/Equilend.jsp");
        borrowerLogin();

        closeUploadBoxIfOpen();
    }

    private boolean closeUploadBoxIfOpen() {
        try {
            driver().findElement(By.xpath("//div[contains(@id, 'header')]//img[contains(@class, 'x-tool-close')]")).click();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

//    public static WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.ie.driver", "src/IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
////        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
////        driver = new ChromeDriver();
////        driver = new FirefoxDriver();
//        driver.get("https://staging.members.equilend.com/");
////        driver.get("https://qa.equilend.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        borrowerLogin();
//    }

    @AfterClass
    public void cleanUp() throws InterruptedException {
        logout();
        driver().quit();
    }
}
