package org.assessment.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assessment.utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * @author verma.piyush
 */
public class BaseClass extends TestBase {

    public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    public BaseClass(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    /*
     * To launch given url
     * if URL value is null then it will take url value from config file
     */
    public void launchUrl(String url) {

        if (url==null) {

            logger.info("url is taking from properties file : ");
            String url1 = prop.getProperty("url");
            driver.navigate().to(url1);
        } else {

            logger.info("url is taking from .xml file : ");
            driver.navigate().to(url);
        }
    }

    /*
     * To close the browser incident
     */
    public void tearDown() {

        driver.quit();
    }
}
