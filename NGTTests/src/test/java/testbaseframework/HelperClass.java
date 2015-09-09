package testbaseframework;

import com.google.common.base.Function;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Parameter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static junit.framework.Assert.assertNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HelperClass extends TestBase {
    public static WebElement element;

    public String getValue;

    public String text;

    @Parameter("Test Step")
    public String testStep;

    public static WebElement getWhenVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        element = wait.until(visibilityOfElementLocated(locator));
        scrollElementIntoView();
        return element;
    }

    public static WebElement getWithfluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                }
        );
        return foo;
    }
//        WebElement result = null;
//        long maxTime = 5 * 1000; // time in milliseconds
//        long timeSlice = 250;
//        long elapsedTime = 0;
//
//        do {
//            try{
//                Thread.sleep(timeSlice);
//                elapsedTime += timeSlice;
//                result = driver().findElement(by);
//            } catch(Exception e) {
//            }
//        } while(result == null && elapsedTime < maxTime);
//
//        return result;

    public static void scrollElementIntoView() {
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(500);
    }

    public static void sleep(int timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadingTimeout() {
        sleep(2000);
    }

    //Generic method for most inputs. Find by CSS Selector, clear input, send a value, and press enter
    public void genericForInputsByCSS(String locator, String value) {
        WebElement input = getWhenVisible(By.cssSelector(locator));
        input.click();
        input.clear();
        input.sendKeys(value);
        input.sendKeys(Keys.ENTER);
        getValue = input.getAttribute("value");
        System.out.println(getValue);
    }

    public void genericForInputsByName(String locator, String value) {
        WebElement input = getWhenVisible(By.name(locator));
        input.click();
        sleep(1000);
        input.clear();
        input.sendKeys(value);
        input.sendKeys(Keys.ENTER);
        getValue = input.getAttribute("value");
        System.out.println(getValue);
    }

//    public boolean waitIsEnabled(WebElement w, boolean b)
//    {
//        int timeoutMs = 500;
//        int timeSlice = 100; // milliseconds
//        do
//        {
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.isEnabled() != b);
//
//        if (timeoutMs <= 0)
//        {
//            return !b;
//        }
//        return b;
//    }

    public void extractJSLogs() {
        LogEntries logEntries = driver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel() == Level.SEVERE) {
                System.out.println(entry.getLevel() + " " + entry.getMessage());
                try {
                    assertNull(entry);
                } catch (AssertionFailedError e) {
                    driver().quit();
                    throw e;
                }
            } else {
                System.out.println(entry.getLevel() + " " + entry.getMessage());
            }
        }
    }

    //Screen capture code
//    public static void captureScreen()
//    {
//        WebDriver augmentedDriver = new Augmenter().augment(threadDriver.get());
//        File srcFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//        File destFile = getDestinationFile();
//        try
//        {
//            FileUtils.copyFile(srcFile, destFile);
//            System.out.println(destFile);
//        }
//        catch (IOException ioe)
//        {
//            throw new RuntimeException(ioe);
//        }
//    }
//
//    private static String addDate()
//    {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd");
//        String formattedDate = formatter.format(date);
//        return formattedDate;
//    }
//
//    private static String addTime() {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
//        String formattedDate = formatter.format(date);
//        return formattedDate;
//    }
//
//    private static File getDestinationFile()
//    {
//        String userDirectory = "qa/var/screenshots/" + addDate() +addTime()+ "/chrome";
//        String url = driver.getCurrentUrl().replace("https://staging2.smartasset.com/", "").replaceAll("/", "_").replaceAll(Pattern.quote("?"), "_");
//        if (url.equals("https://www.jobscore.com/jobs2/smartasset"))
//        {
//            url = "smartasset_jobs";
//        }
//        String fileName = url + ".jpg";
//        if (fileName.equals(".jpg"))
//        {
//            fileName = "_homepage.jpg";
//        }
//        String absoluteFileName = userDirectory + "/" + fileName;
//        return new File(absoluteFileName);
//    }
//    //End screen capture code
//
//    //alert handler (mostly for IE)
//    public static void bypassAlert()
//    {
//        try
//        {
//            WebDriverWait wait = new WebDriverWait(driver(), 2);
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert alert = driver().switchTo().alert();
//            alert.dismiss();
//        }
//        catch (Exception e)
//        {
//            //exception handling
//        }
//    }
}
//
////    public static void sleep(long milliseconds)
////    {
////        try
////        {
////            Thread.sleep(milliseconds);
////        } catch (InterruptedException e) {
////        }
////    }
//
//    /**
//     * Search for elements in the DOM
//     * @param locator how the element(s) should be found in the DOM
//     * @param timeoutMs how long the process should try to find the element(s)
//     * @return List of WebElements, or an empty list if timeout is reached
//     */
//    private static List<WebElement> findElements(By locator, int timeoutMs) {
//        WebDriver driver = driver();
//        List<WebElement> w;
//        long timeSlice = 200; // milliseconds
//        do {
//            w = driver.findElements(locator);
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.size() == 0);
//        return w;
//    }
//
//    /**
//     * Search for elements in the DOM where an expected number is to be found
//     * @param locator how the element(s) should be found in the DOM
//     * @param timeoutMs how long the process should try to find the element(s)
//     * @param expectedNumber number of elements expected to be found
//     * @return List of WebElement objects, or an empty list if timeout is reached
//     */
//    private static List<WebElement> findElements(By locator, int timeoutMs, int expectedNumber) {
//        WebDriver driver = driver();
//        List<WebElement> w;
//        long timeSlice = 200; // milliseconds
//        do {
//            w = driver.findElements(locator);
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.size() < expectedNumber);
//        return w;
//    }
//
//    /**
//     * Create a WebDriverWait object using the default timeout and sleep values
//     * @return WebDriverWait object
//     */
//    private static WebDriverWait getWebDriverWait() {
//        int timeOutInSeconds = getDefaultTimeoutInMilliseconds() / 1000;
//        int sleepInMillis = 200;
//        return new WebDriverWait(driver(), timeOutInSeconds, sleepInMillis);
//    }
//
//    private static int getDefaultTimeoutInMilliseconds()
//    {
//        sleep(2000);
//        return getDefaultTimeoutInMilliseconds();
//    }
//
//    /**
//     * Internal function for waiting until a web element is either enabled or disabled
//     * @param w WebElement to evaluate
//     * @param b true for enabled or false for disabled
//     * @return true if condition is met or false if condition is not met
//     */
//    private static boolean waitIsEnabled(WebElement w, boolean b) {
//        int timeoutMs = getDefaultTimeoutInMilliseconds();
//        long timeSlice = 100; // milliseconds
//        do {
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.isEnabled() != b);
//
//        if (timeoutMs <= 0) {
//            return !b;
//        }
//        return b;
//    }
//
//    /**
//     * Find a single element in the DOM based on the given locator
//     * @param locator how the element should be found in the DOM
//     * @return first matching element in the DOM
//     * @throws NoSuchElementException if no matching elements are found
//     */
//    public static WebElement waitFindElement(By locator) {
//        List<WebElement> w = findElements(locator, getDefaultTimeoutInMilliseconds());
//
//        if (w.isEmpty()) throw new NoSuchElementException(format("Element '%s' not found!", locator.toString()));
//
//        return w.get(0);
//    }
//
//    /**
//     * Find a single element in the DOM based on the given locator and provided timeout length
//     * @param locator how the element should be found in the DOM
//     * @param timeoutMs how long to wait (in ms) before timing out
//     * @return First matching element in the DOM
//     * @throws NoSuchElementException if no matching elements are found
//     */
//    public static WebElement waitFindElementWithTimeout(By locator, int timeoutMs) {
//
//        List<WebElement> w = findElements(locator, timeoutMs);
//
//        if (w.isEmpty()) throw new NoSuchElementException(format("Element '%s' not found!", locator.toString()));
//
//        return w.get(0);
//    }
//
//    /**
//     * Finds a WebElement that is a child of another WebElement.
//     * @param parentWebElement Parent WebElement to start search from
//     * @param locator How the child element should be found in the DOM
//     * @return First matching element in the DOM
//     * @throws NoSuchElementException if no matching elements are found
//     */
//    public static WebElement waitFindElementFromParent(WebElement parentWebElement, By locator) {
//        List<WebElement> w;
//        long timeSlice = 200; // milliseconds
//        int timeoutMs = getDefaultTimeoutInMilliseconds();
//        do {
//            w = parentWebElement.findElements(locator);
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.size() == 0);
//
//        if (w.isEmpty()) throw new NoSuchElementException(format("Element '%s' not found!", locator.toString()));
//
//        return w.get(0);
//    }
//
//    /**
//     * Find all elements in the DOM matching the provided locator
//     * @param locator how the elements should be found in the DOM
//     * @return List of all matching WebElement, or an empty list if no matches are found
//     */
//    public static List<WebElement> waitFindElements(By locator) {
//
//        return findElements(locator, getDefaultTimeoutInMilliseconds());
//    }
//
//    /**
//     * Find all elements in the DOM matching the provided locator.
//     * Continue to wait until the expected number is found OR timeout occurs
//     * @param locator how the elements will be found in the DOM
//     * @param expectedNumber anticipated number of elements to find
//     * @return List of all matching WebElement, or an empty list if no matches are found
//     */
//    public static List<WebElement> waitFindElementsWithExpected(By locator, int expectedNumber) {
//        return findElements(locator, getDefaultTimeoutInMilliseconds(),expectedNumber);
//    }
//
//    /**
//     * Find all elements in the DOM matching the provided locator.
//     * Use the provided timeout value to specify how long before timing out
//     * @param locator how the elements should be found in the DOM
//     * @param timeoutMs how long to wait (in ms) before timing out
//     * @return List of all matching WebElements or an empty list if no matches are found
//     */
//    public static List<WebElement> waitFindElementsWithTimeout(By locator, int timeoutMs) {
//
//        return findElements(locator,timeoutMs);
//    }
//
//    /**
//     * Finds a WebElement that is a child of another WebElement.
//     * @param parentWebElement Parent WebElement to start search from
//     * @param locator How the child elements should be found in the DOM
//     * @return List of all matching WebElements or an empty list if no matches are found
//     */
//    public static List<WebElement> waitFindElementsFromParent(WebElement parentWebElement, By locator) {
//        List<WebElement> w;
//        long timeSlice = 200; // milliseconds
//        int timeoutMs = getDefaultTimeoutInMilliseconds();
//        do {
//            w = parentWebElement.findElements(locator);
//            sleep(timeSlice);
//            timeoutMs -= timeSlice;
//        } while (timeoutMs > 0 && w.size() == 0);
//
//        return w;
//    }
//
//    /**
//     * Wait for an element to achieve a visible state
//     * @param locator how the element should be found in the DOM
//     */
//    public static void waitForElementToBeVisible(By locator) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(visibilityOfElementLocated(locator));
//    }
//
//    /**
//     * Wait for an element to achieve a visible state
//     * @param element WebElement to perform check against
//     */
//    public static void waitForElementToBeVisible(final WebElement element) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return element.isDisplayed();
//            }
//        });
//    }
//
//    /**
//     * Wait for element to achieve an invisible state
//     * @param locator how the element should be found in the DOM
//     */
//    public static void waitForElementToBeInvisible(By locator) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(invisibilityOfElementLocated(locator));
//    }
//
//    /**
//     * Wait for element to achieve an invisible state
//     * @param element WebElement to perform check against
//     */
//    public static void waitForElementToBeInvisible(final WebElement element) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return !element.isDisplayed();
//            }
//        });
//    }
//
//    /**
//     * Wait for WebElement to achieve a clickable state
//     * @param locator how the element should be found in the DOM
//     */
//    public static void waitForElementToBeClickable(By locator) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(elementToBeClickable(locator));
//    }
//
//    /**
//     * Wait for WebElement to achieve a clickable state
//     * @param element WebElement to investigate
//     */
//    public static void waitForElementToBeClickable(final WebElement element) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return element.isDisplayed() && element.isEnabled();
//            }
//        });
//    }
//
//    /**
//     * Wait for a WebElement to achieve an enabled state
//     * @param element WebElement to validate
//     */
//    public static void waitForElementToBeEnabled(WebElement element) throws TimeoutException
//    {
//        boolean isEnabled = waitIsEnabled(element, true);
//        if(!isEnabled){
//            throw new TimeoutException(format("Expected state for WebElement '%s' was not met!", element.getTagName()));
//        }
//    }
//
//    /**
//     * Wait for a WebElement to achieve a disabled state
//     * @param element WebElement to validate
//     */
//    public static void waitForElementToBeDisabled(WebElement element) throws TimeoutException
//    {
//        boolean isDisabled = !waitIsEnabled(element, false);  //call to waitIsEnabled will return false if the element is disabled
//        if(!isDisabled){
//            throw new TimeoutException(format("Expected state for WebElement '%s' was not met!", element.getTagName()));
//        }
//    }
//
//    /**
//     * Wait for a WebElement to achieve a selected state
//     * @param element WebElement to perform check against
//     */
//    public static void waitForElementToBeSelected(WebElement element) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(elementSelectionStateToBe(element, true));
//    }
//
//    /**
//     * Waits until a given condition has been met
//     * @param condition What to wait for
//     */
//    public static void waitForCondition(ExpectedCondition condition) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(condition);
//    }
//
//    /**
//     * Wait until an element no longer exists in the DOM
//     * @param locator how to locate the element in the DOM
//     */
//    public static void waitForElementNotExist(By locator) {
//        try {
//            int timeoutMs = getDefaultTimeoutInMilliseconds();
//            WebDriver driver = driver();
//            WebElement element = driver.findElement(locator);
//            int timeSlice = 100;   // milliseconds
//            while ((element.isDisplayed() || element.isEnabled()) && timeoutMs > 0) {
//                sleep(timeSlice);
//                timeoutMs -= timeSlice;
//                element = driver.findElement(locator);
//            }
//            if (timeoutMs<=0) throw new TimeoutException(format("Element '%s' still exists!", locator.toString()));
//        } catch (StaleElementReferenceException | NoSuchElementException ignored) {
//        }
//        catch (TimeoutException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Wait for given text to show in element
//     * @param text text to locate
//     * @param locator how the element should be found in the DOM
//     */
//    public static void waitForTextToBePresentInElement(String text, By locator) {
//        WebDriverWait wait = getWebDriverWait();
//        wait.until(textToBePresentInElement(locator, text));
//    }
//
//    /**
//     * Simulates moving the mouse cursor to a given element on a web page
//     * @param whereToGo element to move to
//     */
//    public static void moveToElement(WebElement whereToGo){
//        Actions act = new Actions(driver());
//        act.moveToElement(whereToGo).perform();
//    }
//
//    /**
//     * Custom sleep that catches InterruptedException
//     * @param milliseconds length of sleep
//     */
//    public static void sleep(long milliseconds) {
//        try {
//            Thread.sleep(milliseconds);
//        } catch (InterruptedException ignored) {
//        }
//    }
//
//    /**
//     * Find a cookie, delete it then add it back with a new value
//     * @param cookieName cookie to locate
//     * @param newValue new value for cookie
//     */
//    public static void editCookie(String cookieName, String newValue) {
//        Cookie oldCookie = driver().manage().getCookieNamed(cookieName);
//        if(oldCookie==null){
//            String error = format("Cookie '%s' was not found!", cookieName);
//            throw new NullPointerException(error);
//        }else{
//            driver().manage().deleteCookieNamed(cookieName);
//            Cookie newCookie = new Cookie(oldCookie.getName(), newValue, oldCookie.getDomain(), oldCookie.getPath(), oldCookie.getExpiry(), oldCookie.isSecure());
//            driver().manage().addCookie(newCookie);
//            driver().navigate().refresh();
//        }
//    }
//
//    /**
//     * Sets the outer window dimension, not just the view port.  synonymous to window.resizeTo() in JS.
//     * Ignored for Android Platform
//     * @param width window width: note - 213px appears to be the smallest value possible for a width.
//     * @param height window height: note - 123px appears to be the smallest value possible for a height.
//     */
////    public static void setWindowSize(int width, int height) {
////        if(!(p.getSeleniumGridNodePlatform().toUpperCase()=="ANDROID")){
////            Dimension d = new Dimension(width, height);
////            driver().manage().window().setSize(d);
////        }
////    }
//
//    /**
//     * Wrapper for WebDriver manage().window().maximize()
//     * Catches UnsupportedCommandException when maximize is attempted on unsupported WebDriver types (ie: Selendroid for ANDROID)
//     * Wrapping like this means consuming applications DO NOT need to add conditional run time logic in their code
//     */
//    public static void maximizeWindow(){
//        try{
//            driver().manage().window().maximize();
//        }catch(UnsupportedCommandException ignore){
//        }
//    }
//
//    /**
//     * Wait for text to change in a given element.
//     * @param locator how the element should be located in the DOM
//     * @param originalTextValue original value that existed
//     * @throws TimeoutException
//     */
//    public static void waitForTextToChange(By locator, String originalTextValue) throws TimeoutException
//    {
//        int timeoutMs = getDefaultTimeoutInMilliseconds();
//        int timeSlice = 200;
//        WebElement w;
//        boolean textChanged;
//
//        do {
//            try {
//                sleep(timeSlice);
//                w = waitFindElement(locator);
//                textChanged = !w.getText().equals(originalTextValue);
//                timeoutMs -= timeSlice;
//            } catch (StaleElementReferenceException e) {
//                textChanged = false;
//            }
//
//        } while (timeoutMs > 0 && !textChanged);
//
//        if (timeoutMs == 0) {
//            throw new TimeoutException("Text value for element: " + locator.toString() + " never changed.");
//        }
//    }
//
//    /**
//     * Wrapper for deleting cookies in the browser.  This will ensure cookies are deleted regardless of the browser.
//     */
//    public static void deleteCookies(){
//        //FOR IE
//        ((JavascriptExecutor) driver()).executeScript("document.execCommand('ClearAuthenticationCache')");
//
//        //FOR Safari
//        driver().manage().getCookies().clear();
//
//        //Default
//        driver().manage().deleteAllCookies();
//    }
//
//}
