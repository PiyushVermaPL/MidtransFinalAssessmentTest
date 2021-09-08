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
public class OrderFailedScreenPopUp extends BaseClass {

    private static final Logger logger = LogManager.getLogger(OrderFailedScreenPopUp.class);

    public OrderFailedScreenPopUp(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //credit/debit card title
    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement creditDebitCardTitle;

    //transaction failed status
    @FindBy(xpath = "//div[@class='text-failed text-bold']/span")
    WebElement transactionFailedMessage;

    //choose another payment option
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement chooseAnotherPaymentOption;


    //Verify clicking on OK button with Invalid OTP should redirect user to order failed screen
    public boolean verifyUserIsOnOrderFailedScreenPopUp () {

        pauseExecution(1);
        switchDefaultContent();
        frameSwitchTo(0);
        pauseExecution(1);
        boolean flag = false;
        explicitWaitForVerifyingElement(driver , 40 , transactionFailedMessage);
        if (transactionFailedMessage.isDisplayed()) {

            flag = true;
            logger.info("User is redirected to the order failed screen after clicking on OK button with Invalid OTP (1234321) : ");
        } else {

            logger.info("User is redirected to the order failed screen after clicking on OK button with Invalid OTP (1234321) : ");
        }
        return flag;
    }

    //verify transaction status message
    public boolean verifyTransactionSuccessfulMsg (String expectedTransactionFailedMsgX) {

        boolean flag = false;
        String actualMsg = transactionFailedMessage.getText();
        String expectedMsg = prop.getProperty("transactionFailedStatus");

        if (expectedTransactionFailedMsgX==null) {

            logger.info("Expected message is taking from Properties File : ");
            if (actualMsg.equalsIgnoreCase(expectedMsg)) {

                flag = true;
                logger.info("Message on Transaction Failed Screen PopUp is same as Expected : ");
            } else {

                logger.info("Message on Transaction Failed Screen PopUp is not same as Expected : ");
            }
        } else {

            logger.info("Expected message is taking from .xml File : ");
            if (actualMsg.equalsIgnoreCase(expectedTransactionFailedMsgX)) {

                flag = true;
                logger.info("Message on Transaction Failed Screen PopUp is same as Expected : ");
            } else {

                logger.info("Message on Transaction Failed Screen PopUp is not same as Expected : ");
            }
        }
        return flag;
    }

    //click on choose another payment option Button
    public SelectPaymentPopUp clickOnChooseAnotherPaymentOption () {

        explicitWaitForClick(driver , 50 , chooseAnotherPaymentOption);
        return new SelectPaymentPopUp(driver);
    }
}
