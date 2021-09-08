package org.assessment.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*
 * @author verma.piyush
 */
public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop = new Properties();
    private static final Logger logger = LogManager.getLogger(TestBase.class);

    public TestBase() {

        FileInputStream fis = null;
        try {

            fis = new FileInputStream("src//main//resources//configureFiles//config.properties");
            prop.load(fis);
        } catch (IOException e1) {

            logger.error(e1);
        }
    }

    //define cluster to initialize the browser which return webdriver
    public WebDriver initializingBrowser(String browser) {

        String browserName = prop.getProperty("browser");
        logger.info("initializing browser set for Test Execution : ");
        if (browser==null) {

            if (browserName.equalsIgnoreCase("chrome")) {

                logger.info("browser Name is taking from properties file : ");
                logger.info("opening chrome browser : ");
                System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
                logger.info("chrome browser property set : ");
                driver = new ChromeDriver();
                logger.info("maximizing the browser window : ");
                driver.manage().window().maximize();
            } else if (browserName.equalsIgnoreCase("firefox")) {

                logger.info("browser Name is taking from properties file : ");
                logger.info("opening firefox browser : ");
                System.setProperty("webdriver.gecko.driver" , "src//main//resources//drivers//geckodriver.exe");
                logger.info("firefox browser property set : ");
                driver = new FirefoxDriver();
                logger.info("maximizing the browser window : ");
                driver.manage().window().maximize();
            } else {

                System.out.println("You have entered wrong Parameters : ");
                System.out.println("***Thank-You***");
            }
        } else {

            if (browser.equalsIgnoreCase("chrome")) {

                logger.info("browser Name is taking from properties file : ");
                logger.info("opening chrome browser : ");
                System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//chromedriver.exe");
                logger.info("chrome browser property set : ");
                driver = new ChromeDriver();
                logger.info("maximizing the browser window : ");
                driver.manage().window().maximize();
                //driver.manage().window().setSize(2000,2000);
            } else if (browser.equalsIgnoreCase("firefox")) {

                logger.info("browser Name is taking from properties file : ");
                logger.info("opening firefox browser : ");
                System.setProperty("webdriver.gecko.driver", "src//main//resources//drivers//geckodriver.exe");
                logger.info("firefox browser property set : ");
                driver = new FirefoxDriver();
                logger.info("maximizing the browser window : ");
                driver.manage().window().maximize();
            } else {

                System.out.println("You have entered wrong Parameters : ");
                System.out.println("***Thank-You***");
            }
        }

        logger.info("defining implicitlyWait and PageLoad Wait : ");
        driver.manage().timeouts().implicitlyWait(UtilsTime.implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(UtilsTime.pageLoadWait , TimeUnit.SECONDS);
        return driver;
    }

    /*
     * To pause execution if website is unstable
     * not recommended using this method
     * use only when explicit wait is fail to handle situation
     * @param seconds duration to pause execution
     */
    public void pauseExecution(int seconds) {

        String msg = "pause execution for " + seconds + " : ";
        try {

            logger.info(msg);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

            logger.error(e);
        }
    }

    //taking current date & time
    public static String currentDateAndTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss_ms");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    //take screenShot when test getting failed
    public void takeScreenShotOnTestFailure() {

        String time = currentDateAndTime();
        String screenShotPath = "screenShots" + "\\\\" + "ScreenShot_" + time + ".jpeg";

        TakesScreenshot scr = ((TakesScreenshot) driver);

        File src = scr.getScreenshotAs(OutputType.FILE);

        File dest = new File(screenShotPath);

        logger.info("driver is taking ScreenShot On Test failure : ");
        try {

            FileUtils.copyFile(src , dest);
        } catch (IOException e) {

            logger.error(e);
        }
    }

    //explicit wait for click
    public void explicitWaitForClick(WebDriver driver , int time , WebElement clickingElement) {

        String msg = "explicit wait for clicking is using : " + clickingElement;
        logger.info(msg);
        new WebDriverWait(driver , time).
                until(ExpectedConditions.elementToBeClickable(clickingElement));
        clickingElement.click();
    }

    //explicit wait for sendKeys
    public void explicitWaitForSenKeys(WebDriver driver , int time , WebElement sendKeysElement , String value) {

        String msg = "explicit wait for sendKeys is using : " + sendKeysElement;
        logger.info(msg);
        new WebDriverWait(driver , time).
                until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.clear();
        sendKeysElement.sendKeys(value);
    }

    //explicit wait for verification
    public void explicitWaitForVerifyingElement(WebDriver driver , int time , WebElement verifyElement){

        String msg = "explicit wait for verifying element is using : " + verifyElement;
        logger.info(msg);
        new WebDriverWait(driver , time).
                until(ExpectedConditions.visibilityOf(verifyElement));
    }

    //get Locator for the list of elements which have common xPath
    public String getLocator (String beforeXpath , String middleXpath , String afterXpath) {

        String xpath = beforeXpath + middleXpath + afterXpath;
        return xpath;
    }

    //Method to Switch frame
    public void frameSwitchTo(int index)
    {

        try {

            driver.switchTo().frame(index);
        } catch (NoSuchWindowException e) {

            driver.switchTo().window(driver.getWindowHandle());
            driver.switchTo().frame(index);
        }
    }

    //Method to focus to defaultContent
    public void switchDefaultContent()
    {

        driver.switchTo().defaultContent();
    }

    //browser screen zoom in
    public void setZoomLevelIncrease (int times) {

        try {
            Robot robot = new Robot();

            for (int i=0;i<times;i++) {

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ADD);
                robot.keyRelease(KeyEvent.VK_ADD);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException e) {

            logger.info(e);
        }
    }

    //browser screen zoom out
    public void setZoomLevelDecrease (int times) {

        try {

            Robot robot = new Robot();

            for (int i=0;i<times;i++) {

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException e) {

            logger.info(e);
        }
    }
}
