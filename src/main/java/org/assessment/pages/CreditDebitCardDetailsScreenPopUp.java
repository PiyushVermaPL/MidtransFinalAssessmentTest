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
public class CreditDebitCardDetailsScreenPopUp extends  BaseClass {

    private static final Logger logger = LogManager.getLogger(CreditDebitCardDetailsScreenPopUp.class);

    public CreditDebitCardDetailsScreenPopUp (WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //Credit/Debit Card PopUp
    @FindBy(xpath = "//p[@class='text-page-title-content' and contains(.,'Credit/Debit Card')]")
    WebElement creditDebitCardPopUp;

    //amount
    @FindBy(xpath = "//div[@class='amount']//div/span[@class='text-amount-amount']")
    WebElement amount;

    //promo coupon checkbox
    @FindBy(xpath = "//span[@class='pull-right text-gray' and contains(.,'- Rp 2,000')]/following-sibling::input")
    WebElement promoCoupon;

    //card Number
    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement cardNumber;

    //expiry Date
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement expiryDate;

    //cvv
    @FindBy(xpath = "//div[@class='input-group col-xs-5']/input")
    WebElement cvv;

    //pay Now Button
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement payNowButton;

    //verify Credit/Debit Card PopUp
    public boolean verifyUserIsOnCreditDebitCardDetailsPopUp () {

        explicitWaitForVerifyingElement(driver , 40 , creditDebitCardPopUp);
        boolean flag = false;
        if (creditDebitCardPopUp.isDisplayed()) {

            flag = true;
            logger.info("User redirected to card details screen after clicking on Credit/Debit Card payment method : ");
        } else {

            logger.info("User is not redirected to card details screen after clicking on Credit/Debit Card payment method : ");
        }
        return flag;
    }

    //Verify order amount on card details screen and apply coupon code and validate changes in amount
    public boolean verifyOrderAmountBeforeAndAfterApplyPromo (String amountBeforeApplyPromoX , String amountAfterApplyPromoX) {

        boolean flag1 = false;
        boolean flag2 = false;

        String amountBeforeApplyPromoP = prop.getProperty("productCost");
        String amountAfterApplyPromoP = prop.getProperty("productCostAfterApplyPromo");

        if (amountBeforeApplyPromoX==null || amountAfterApplyPromoX==null) {

            logger.info("Details is taking From Properties File : ");
            if (promoCoupon.isSelected()) {

                promoCoupon.click();
                String amountBeforeApplyPromo = amount.getText();
                if (amountBeforeApplyPromo.equalsIgnoreCase(amountBeforeApplyPromoP)) {

                    flag1 = true;
                    logger.info("Before apply promo coupon Amount on card details screen is same as order Amount : ");
                } else {

                    logger.info("Before apply promo coupon Amount on card details screen is not same as order Amount : ");
                }
                //Apply Promo Coupon
                promoCoupon.click();
                String amountAfterApplyPromo = amount.getText();
                if (amountAfterApplyPromo.equalsIgnoreCase(amountAfterApplyPromoP)) {

                    flag2 = true;
                    logger.info("After apply promo coupon Amount on card details screen is reflected by 2000 : ");
                } else {

                    logger.info("After apply promo coupon Amount on card details screen is not reflected by 2000 : ");
                }
            } else {

                String amountBeforeApplyPromo = amount.getText();
                if (amountBeforeApplyPromo.equalsIgnoreCase(amountBeforeApplyPromoP)) {

                    flag1 = true;
                    logger.info("Before apply promo coupon Amount on card details screen is same as order Amount : ");
                } else {

                    logger.info("Before apply promo coupon Amount on card details screen is not same as order Amount : ");
                }
                //Apply Promo Coupon
                promoCoupon.click();
                String amountAfterApplyPromo = amount.getText();
                if (amountAfterApplyPromo.equalsIgnoreCase(amountAfterApplyPromoP)) {

                    flag2 = true;
                    logger.info("After apply promo coupon Amount on card details screen is reflected by 2000 : ");
                } else {

                    logger.info("After apply promo coupon Amount on card details screen is not reflected by 2000 : ");
                }
            }
        } else {


            logger.info("Details is taking From .xml File : ");
            if (promoCoupon.isSelected()) {

                promoCoupon.click();
                String amountBeforeApplyPromo = amount.getText();
                if (amountBeforeApplyPromo.equalsIgnoreCase(amountBeforeApplyPromoX)) {

                    flag1 = true;
                    logger.info("Before apply promo coupon Amount on card details screen is same as order Amount : ");
                } else {

                    logger.info("Before apply promo coupon Amount on card details screen is not same as order Amount : ");
                }
                //Apply Promo Coupon
                promoCoupon.click();
                String amountAfterApplyPromo = amount.getText();
                if (amountAfterApplyPromo.equalsIgnoreCase(amountAfterApplyPromoX)) {

                    flag2 = true;
                    logger.info("After apply promo coupon Amount on card details screen is reflected by 2000 : ");
                } else {

                    logger.info("After apply promo coupon Amount on card details screen is not reflected by 2000 : ");
                }
            } else {

                String amountBeforeApplyPromo = amount.getText();
                if (amountBeforeApplyPromo.equalsIgnoreCase(amountBeforeApplyPromoX)) {

                    flag1 = true;
                    logger.info("Before apply promo coupon Amount on card details screen is same as order Amount : ");
                } else {

                    logger.info("Before apply promo coupon Amount on card details screen is not same as order Amount : ");
                }
                //Apply Promo Coupon
                promoCoupon.click();
                String amountAfterApplyPromo = amount.getText();
                if (amountAfterApplyPromo.equalsIgnoreCase(amountAfterApplyPromoX)) {

                    flag2 = true;
                    logger.info("After apply promo coupon Amount on card details screen is reflected by 2000 : ");
                } else {

                    logger.info("After apply promo coupon Amount on card details screen is not reflected by 2000 : ");
                }
            }
        }

        return flag1 && flag2;
    }

    //enter valid card details
    public void enterCardDetails(String cardNumberValX , String expiryDateValX , String cvvValX) {

        String cardNumberVal = prop.getProperty("cardNumber");
        String expiryDateVal = prop.getProperty("expiryDate");
        String cvvVal = prop.getProperty("cvv");

        if (cardNumberValX==null || expiryDateValX==null || cvvValX==null) {

            logger.info("Card details is taking from Properties File : ");
            explicitWaitForSenKeys(driver , 40 , cardNumber , cardNumberVal);
            explicitWaitForSenKeys(driver , 40 , expiryDate , expiryDateVal);
            explicitWaitForSenKeys(driver , 40 , cvv , cvvVal);
        } else {

            logger.info("Card details is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , cardNumber , cardNumberValX);
            explicitWaitForSenKeys(driver , 40 , expiryDate , expiryDateValX);
            explicitWaitForSenKeys(driver , 40 , cvv , cvvValX);
        }
    }

    //click on pay Now Button
    public BankPaymentScreenPopUp clickOnPayNowButton () {

        explicitWaitForClick(driver , 40 , payNowButton);
        return new BankPaymentScreenPopUp(driver);
    }
}
