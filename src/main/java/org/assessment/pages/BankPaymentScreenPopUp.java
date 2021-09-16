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
public class BankPaymentScreenPopUp extends BaseClass {

    private static final Logger logger = LogManager.getLogger(BankPaymentScreenPopUp.class);

    public BankPaymentScreenPopUp (WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //bank Payment Screen
    @FindBy(xpath = "//h1[contains(.,'Issuing Bank')]")
    WebElement bankPaymentScreen;

    //merchant Name
    @FindBy(xpath = "//label[contains(.,'Merchant Name:')]/following-sibling::div/p[@id='merchant_name']")
    WebElement merchantName;

    //card Number On Payment Screen
    @FindBy(xpath = "//label[contains(.,'Card Number:')]/following-sibling::div/p[@id='card_number']")
    WebElement cardNumberOnPaymentScreen;

    //amount
    @FindBy(xpath = "//label[contains(.,'Amount:')]/following-sibling::div/p[@id='txn_amount']")
    WebElement amount;

    //password OTP
    @FindBy(xpath = "//input[@id='PaRes']")
    WebElement passwordOTP;

    //ok Button
    @FindBy(xpath = "//button[@class='btn btn-sm btn-success']")
    WebElement okButton;

    //Cancel Button
    @FindBy(xpath = "//button[@name='cancel']")
    WebElement cancelButton;

    //resend Button
    @FindBy(xpath = "//button[@name='resend']")
    WebElement resendButton;



    //verify bank Payment Screen PopUp
    public boolean verifyUserIsOnBankPaymentScreenPopUp () {

        explicitWaitForVerifyingElement(driver , 40 , bankPaymentScreen);
        boolean flag = false;
        if (bankPaymentScreen.isDisplayed()) {

            flag = true;
            logger.info("User is redirected to the Bank Payment Screen PopUp after clicking on Payment Now Button : ");
        } else {

            logger.info("User is not redirected to the Bank Payment Screen PopUp after clicking on Payment Now Button : ");
        }
        return flag;
    }

    //verify details on bank payment screen
    public boolean verifyDetailsOnBankPaymentScreen (String expectedMerchantNameX , String expectedAmountX , String expectedCardNumberX) {

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        //expected details from properties File
        String expectedMerchantName = prop.getProperty("merchantName");
        String expectedAmount = prop.getProperty("amount");
        String expectedCardNumber    = prop.getProperty("cardNumber");
        String expectedLastFourDigit = expectedCardNumber.substring(expectedCardNumber.length() - 4);

        //actual details
        String actualMerchantName   = merchantName.getText();
        String actualAmount         = amount.getText();
        String actualCardNumber     = cardNumberOnPaymentScreen.getText();
        String actualLastFourDigit  = actualCardNumber.substring(actualCardNumber.length() - 4);

        //verify merchant name on bank payment screen popup
        if (expectedMerchantNameX==null || expectedAmountX==null || expectedCardNumberX==null) {

            logger.info("Details is taking from Properties File : ");
            if (actualMerchantName.equalsIgnoreCase(expectedMerchantName)) {

                flag1 = true;
                logger.info("Merchant name is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Merchant name is not correct on Bank Payment Screen PopUp : ");
            }

            //verify amount on bank payment screen popup
            if (actualAmount.equalsIgnoreCase(expectedAmount)) {

                flag2 = true;
                logger.info("Amount is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Amount is not correct on Bank Payment Screen PopUp : ");
            }

            //verify card number on bank payment screen popup
            if (actualLastFourDigit.equalsIgnoreCase(expectedLastFourDigit)) {

                flag3 = true;
                logger.info("Last four digit of card is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Last four digit of card is not correct on Bank Payment Screen PopUp : ");
            }
        } else {

            //expected details from .xml File
            String expectedLastFourDigitX = expectedCardNumberX.substring(expectedCardNumberX.length() - 4);
            logger.info("Details is taking from .xml File : ");

            if (actualMerchantName.equalsIgnoreCase(expectedMerchantNameX)) {

                flag1 = true;
                logger.info("Merchant name is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Merchant name is not correct on Bank Payment Screen PopUp : ");
            }

            //verify amount on bank payment screen popup
            if (actualAmount.equalsIgnoreCase(expectedAmountX)) {

                flag2 = true;
                logger.info("Amount is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Amount is not correct on Bank Payment Screen PopUp : ");
            }

            //verify card number on bank payment screen popup
            if (actualLastFourDigit.equalsIgnoreCase(expectedLastFourDigitX)) {

                flag3 = true;
                logger.info("Last four digit of card is correct on Bank Payment Screen PopUp : ");
            } else {

                logger.info("Last four digit of card is not correct on Bank Payment Screen PopUp : ");
            }
        }
        return flag1 && flag2 && flag3;
    }

    //enter valid OTP
    public void enterValidOTP (String validOTPX) {

        if (validOTPX==null) {

            logger.info("Valid OTP is taking from Properties File : ");
            String validOTP = prop.getProperty("validOTP");
            explicitWaitForSenKeys(driver , 40 , passwordOTP , validOTP);
        } else {

            logger.info("Valid OTP is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , passwordOTP , validOTPX);
        }
    }

    //enter invalid OTP
    public void enterInvalidOTP (String inValidOTPX) {

        if (inValidOTPX==null) {

            String inValidOTP = prop.getProperty("inValidOTP");
            logger.info("Invalid OTP is taking from Properties FIle : ");
            explicitWaitForSenKeys(driver , 40 , passwordOTP , inValidOTP);
        } else {

            logger.info("Invalid OTP is taking from .xml FIle : ");
            explicitWaitForSenKeys(driver , 40 , passwordOTP , inValidOTPX);
        }
    }

    //click on ok Button
    public OrderSuccessfulScreenPopUp clickOnOkButtonForOrderSuccessfulScreenPopUp () {

        explicitWaitForClick(driver , 40 , okButton);
        return new OrderSuccessfulScreenPopUp(driver);
    }

    //click on ok Button
    public MidTransHomePage clickOnOkButtonForMidTransHomePage () {

        explicitWaitForClick(driver , 40 , okButton);
        return new MidTransHomePage(driver);
    }

    //click on ok Button
    public OrderFailedScreenPopUp clickOnOkButtonForOrderFailedScreenPopUp () {

        explicitWaitForClick(driver , 40 , okButton);
        return new OrderFailedScreenPopUp(driver);
    }

    //click on Cancel Button
    public OrderFailedScreenPopUp clickOnCancelButton () {

        explicitWaitForClick(driver , 40 , cancelButton);
        return new OrderFailedScreenPopUp(driver);
    }

    //click On resend Button
    public void clickOnResendButton () {

        explicitWaitForClick(driver , 40 , resendButton);
    }
}
