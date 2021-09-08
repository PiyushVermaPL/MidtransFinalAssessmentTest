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

public class SelectPaymentPopUp extends BaseClass {

    private static final Logger logger = LogManager.getLogger(SelectPaymentPopUp.class);

    public SelectPaymentPopUp(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //select payment
    @FindBy(xpath = "//p[contains(.,'Select Payment')]")
    WebElement selectPayment;

    //debit/credit card option
    @FindBy(xpath = "//div[@class='list-content']//div[contains(.,'Credit/Debit Card')]")
    WebElement debitCreditCardOption;

    //ATM/Bank Transfer Option
    @FindBy(xpath = "//div[@class='list-content']//div[contains(.,'ATM/Bank Transfer')]")
    WebElement atmBankTransferOption;

    //GoPay/other e-Wallets option
    @FindBy(xpath = "//div[@class='list-content']//div[contains(.,'GoPay/other e-Wallets')]")
    WebElement goPayOtherEWalletsOption;

    //ShopeePay/other e-Wallets option
    @FindBy(xpath = "//div[@class='list-content']//div[contains(.,'ShopeePay/other e-Wallets')]")
    WebElement shopeePayOtherEWalletsOption;

    //KlikBCA option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'KlikBCA')])[1]")
    WebElement klikBCAOption;

    //BCA KlikPay Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'BCA KlikPay')])[1]")
    WebElement bcaKlikPayOption;

    //OCTO Clicks Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'OCTO Clicks')])[1]")
    WebElement octoClicksOption;

    //Danamon Online Banking Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'Danamon Online Banking')])[1]")
    WebElement danamonOnlineBankingOption;

    //e-Pay BRI Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'e-Pay BRI')])[1]")
    WebElement ePayBRIOption;

    //LINE Pay e-cash | mandiri e-cash Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'LINE Pay e-cash | mandiri e-cash')])[1]")
    WebElement linePayECashMandiriECashOption;

    //Telkomsel Cash Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'Telkomsel Cash')])[1]")
    WebElement telkomselCashOption;

    //Indomaret Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'Indomaret')])[1]")
    WebElement indomaretOption;

    //Alfa Group Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'Alfa Group')])[1]")
    WebElement alfaGroupOption;

    //Akulaku Option
    @FindBy(xpath = "(//div[@class='list-content']//div[contains(.,'Akulaku')])[1]")
    WebElement akulakuOption;



    //verify select payment page title
    public boolean verifyUserIsOnSelectPaymentOptionsPopUp () {

        explicitWaitForVerifyingElement(driver , 40 , selectPayment);
        boolean flag = false;
        if (selectPayment.isDisplayed()) {

            flag = true;
            logger.info("User redirected to the Select payment Page after clicking on continue button on order summery : ");
        } else {

            logger.info("User is redirected to the Select payment Page after clicking on continue button on order summery : ");
        }
        return flag;
    }

    //Verify all the payment options listed on payment page
    public boolean verifyPaymentOptionsList () {

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        boolean flag10 = false;
        boolean flag11 = false;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;

        if (atmBankTransferOption.isDisplayed()) {

            flag1 = true;
            logger.info("ATM Bank Transfer payment option is available in payment mode Options : ");
        } else {

            logger.info("ATM Bank Transfer payment option is not available in payment mode Options : ");
        }

        if (goPayOtherEWalletsOption.isDisplayed()) {

            flag2 = true;
            logger.info("Go Pay Other E-Wallets Option is available in payment mode Options : ");
        } else {

            logger.info("Go Pay Other E-Wallets option is not available in payment mode Options : ");
        }

        if (shopeePayOtherEWalletsOption.isDisplayed()) {

            flag3 = true;
            logger.info("Shopee Pay Other E-Wallets Option is available in payment mode Options : ");
        } else {

            logger.info("Shopee Pay Other E-Wallets Option is not available in payment mode Options : ");
        }

        if (klikBCAOption.isDisplayed()) {

            flag4 = true;
            logger.info("Klik BCA Option is available in payment mode Options : ");
        } else {

            logger.info("Klik BCA Option is not available in payment mode Options : ");
        }

        if (bcaKlikPayOption.isDisplayed()) {

            flag5 = true;
            logger.info("BCA Klik Pay Option is available in payment mode Options : ");
        } else {

            logger.info("BCA Klik Pay Option is not available in payment mode Options : ");
        }

        if (octoClicksOption.isDisplayed()) {

            flag6 = true;
            logger.info("OCTO Clicks Option is available in payment mode Options : ");
        } else {

            logger.info("OCTO Clicks Option is not available in payment mode Options : ");
        }

        if (danamonOnlineBankingOption.isDisplayed()) {

            flag7 = true;
            logger.info("Danamon Online Banking Option is available in payment mode Options : ");
        } else {

            logger.info("Danamon Online Banking Option is not available in payment mode Options : ");
        }

        if (ePayBRIOption.isDisplayed()) {

            flag8 = true;
            logger.info("e-Pay BRI Option is available in payment mode Options : ");
        } else {

            logger.info("e-Pay BRI Option is not available in payment mode Options : ");
        }

        if (linePayECashMandiriECashOption.isDisplayed()) {

            flag9 = true;
            logger.info("Line Pay E-Cash Mandiri E-Cash Option is available in payment mode Options : ");
        } else {

            logger.info("Line Pay E-Cash Mandiri E-Cash Option is not available in payment mode Options : ");
        }

        if (telkomselCashOption.isDisplayed()) {

            flag10 = true;
            logger.info("Telkomsel Cash Option is available in payment mode Options : ");
        } else {

            logger.info("Telkomsel Cash Option is not available in payment mode Options : ");
        }

        if (indomaretOption.isDisplayed()) {

            flag11 = true;
            logger.info("Indomaret Option is available in payment mode Options : ");
        } else {

            logger.info("Indomaret Option is not available in payment mode Options : ");
        }

        if (alfaGroupOption.isDisplayed()) {

            flag12 = true;
            logger.info("Alfa Group Option is available in payment mode Options : ");
        } else {

            logger.info("Alfa Group Option is not available in payment mode Options : ");
        }

        if (akulakuOption.isDisplayed()) {

            flag13 = true;
            logger.info("Akulaku Option is available in payment mode Options : ");
        } else {

            logger.info("Akulaku Option is not available in payment mode Options : ");
        }

        if (debitCreditCardOption.isDisplayed()) {

            flag14 = true;
            logger.info("Debit/Credit Card Option is available in payment mode Options : ");
        } else {

            logger.info("Debit/Credit Card Option is not available in payment mode Options : ");
        }

        return flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14;
    }

    //click on Credit/Debit Card payment method
    public CreditDebitCardDetailsScreenPopUp clickOnCreditDebitCardPaymentOption () {

        explicitWaitForClick(driver , 40 , debitCreditCardOption);
        return new CreditDebitCardDetailsScreenPopUp(driver);
    }
}
