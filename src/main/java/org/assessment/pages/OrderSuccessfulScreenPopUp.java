package org.assessment.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author verma.piyush
 */
public class OrderSuccessfulScreenPopUp extends BaseClass {

    private static Logger logger = LogManager.getLogger(OrderSuccessfulScreenPopUp.class);

    public OrderSuccessfulScreenPopUp(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //payment successful message
    @FindBy(xpath = "//div[@class='text-success text-bold']")
    WebElement paymentSuccessfulMessage;

    //icon
    @FindBy(xpath = "//i[@class='icon checkmark']")
    WebElement icon;

    //done button
    @FindBy(xpath = "//div[@class='text-button-main']")
    WebElement doneButton;


    //verify order successful screen PopUp
    public boolean verifyUserIsOnOrderSuccessfulScreenPopUp () {

        pauseExecution(1);
        switchDefaultContent();
        frameSwitchTo(0);
//        pauseExecution(1);
//        frameSwitchTo(0);
        pauseExecution(1);
        boolean flag = false;
        if (paymentSuccessfulMessage.isDisplayed()) {

            flag = true;
            logger.info("User is redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        } else {

            logger.info("User is not redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        }
        return flag;
    }

    //verify payment successful message
    public boolean verifyPaymentSuccessfulMsg (String expectedTransactionSuccessfulMessageX) {

        pauseExecution(1);
        switchDefaultContent();
        frameSwitchTo(0);
//        pauseExecution(1);
//        frameSwitchTo(0);
        pauseExecution(1);
        boolean flag = false;

        String actualMsg   = paymentSuccessfulMessage.getText();

        if (expectedTransactionSuccessfulMessageX==null) {

            logger.info("Expected successful message is taking from Properties File : ");
            String expectedMsg = prop.getProperty("transactionSuccessfulStatus");
            if (actualMsg.equalsIgnoreCase(expectedMsg)) {

                flag = true;
                logger.info("Message on Transaction Successful Screen PopUp is same as Expected : ");
            } else {

                logger.info("Message on Transaction Successful Screen PopUp is not same as Expected : ");
            }
        } else {

            logger.info("Expected successful message is taking from .xml File : ");
            if (actualMsg.equalsIgnoreCase(expectedTransactionSuccessfulMessageX)) {

                flag = true;
                logger.info("Message on Transaction Successful Screen PopUp is same as Expected : ");
            } else {

                logger.info("Message on Transaction Successful Screen PopUp is not same as Expected : ");
            }
        }
        return flag;
    }

    //verify order successful screen PopUp
    public boolean verifyUserIsOnOrderSuccessfulScreenPopUpByIcon () {

        pauseExecution(1);
        switchDefaultContent();
        frameSwitchTo(0);
//        pauseExecution(1);
//        frameSwitchTo(0);
        pauseExecution(1);
        explicitWaitForVerifyingElement(driver , 10 , icon);
        boolean flag = false;
        if (icon.isDisplayed()) {

            flag = true;
            logger.info("User is redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        } else {

            logger.info("User is not redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        }
        return flag;
    }

    //verify order successful screen PopUp
    public boolean verifyUserIsOnOrderSuccessfulScreenPopUpByByDoneButton () {

        pauseExecution(1);
        switchDefaultContent();
        frameSwitchTo(0);
//        pauseExecution(1);
//        frameSwitchTo(0);
        pauseExecution(1);
        explicitWaitForVerifyingElement(driver , 10 , doneButton);
        boolean flag = false;
        if (doneButton.isDisplayed()) {

            flag = true;
            logger.info("User is redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        } else {

            logger.info("User is not redirected to the order successful screen after clicking on OK button with Valid OTP (112233) : ");
        }
        return flag;
    }
}
