package org.assessment.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author verma.piyush
 */
public class SelectPaymentPopUp1 extends BaseClass {

    private static final Logger logger = LogManager.getLogger(SelectPaymentPopUp1.class);

    public SelectPaymentPopUp1(WebDriver driver) {

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
    public boolean verifyUserIsOnSelectPaymentPopUp () {

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

    //xpath for Payment mode options
    String beforeXpathForPaymentMode = "(//div[@class='list-content']//div[contains(.,'";
    String afterXpathForPaymentMode = "')])[1]";

    String[] middleXpathForPaymentOptions = {"Credit/Debit Card" , "ATM/Bank Transfer" , "GoPay/other e-Wallets" ,
            "ShopeePay/other e-Wallets" , "KlikBCA" , "BCA KlikPay" , "OCTO Clicks" , "Danamon Online Banking" ,
            "e-Pay BRI" , "LINE Pay e-cash | mandiri e-cash" , "Telkomsel Cash" , "Indomaret" , "Alfa Group" , "Akulaku"};

    //verify Presence of all payment mode Options
    public boolean verifyPaymentModeOptions () {

        boolean flag = true;
        for (String s : middleXpathForPaymentOptions) {

            String msgForPresent    = s + " payment option is available in payment mode Options : ";
            String msgForNotPresent = s + " payment option is not available in payment mode Options : ";

            try {

                WebElement element = driver.findElement(By.xpath(getLocator(beforeXpathForPaymentMode , s , afterXpathForPaymentMode)));
                if (element.isDisplayed()) {

                    logger.info(msgForPresent);
                }
            } catch (NoSuchElementException e) {

                flag = false;
                logger.info(msgForNotPresent);
            }
        }
        return flag;
    }

    //click on Credit/Debit Card payment method
    public CreditDebitCardDetailsScreenPopUp clickOnCreditDebitCardPaymentOption () {

        explicitWaitForClick(driver , 40 , debitCreditCardOption);
        return new CreditDebitCardDetailsScreenPopUp(driver);
    }
}
