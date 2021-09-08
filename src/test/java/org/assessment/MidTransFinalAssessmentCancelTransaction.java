package org.assessment;

import org.assessment.pages.*;
import org.assessment.utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * @author verma.piyush
 */
public class MidTransFinalAssessmentCancelTransaction {

    WebDriver driver;
    TestBase testBase = new TestBase();
    BaseClass baseClass;
    MidTransHomePage midTransHomePage;
    ShoppingCartPopUp shoppingCartPopUp;
    OrderSummaryScreenPopUp orderSummaryScreenPopUp;
    SelectPaymentPopUp1 selectPaymentPopUp;
    CreditDebitCardDetailsScreenPopUp creditDebitCardDetailsScreenPopUp;
    BankPaymentScreenPopUp bankPaymentScreenPopUp;
    OrderFailedScreenPopUp orderFailedScreenPopUp;

    public void  _init() {

        baseClass = new BaseClass(driver);
        midTransHomePage = new MidTransHomePage(driver);
        shoppingCartPopUp = new ShoppingCartPopUp(driver);
        orderSummaryScreenPopUp = new OrderSummaryScreenPopUp(driver);
        selectPaymentPopUp = new SelectPaymentPopUp1(driver);
        creditDebitCardDetailsScreenPopUp = new CreditDebitCardDetailsScreenPopUp(driver);
        bankPaymentScreenPopUp = new BankPaymentScreenPopUp(driver);
        orderFailedScreenPopUp = new OrderFailedScreenPopUp(driver);
    }

    @Parameters({"BrowserNameX"})
    @BeforeTest()
    public void openBrowser (@Optional String browserNameX) {

        driver = testBase.initializingBrowser (browserNameX);
        _init();
//        testBase.pauseExecution(2);
    }

    @Parameters("UrlX")
    @Test(priority = 1 , groups = {"Regression" , "Smoke"})
    public void enterURL(@Optional String urlX) {

        baseClass.launchUrl(urlX);
//        testBase.pauseExecution(2);
    }

    @Test(priority = 2 , groups = {"Regression" , "Smoke"})
    public void VerifyClickingOnBuyNowButtonUserRedirectToTheCheckoutPopUp () {

        Assert.assertTrue(midTransHomePage.checkAvailabilityOfBuyNowButton());
        midTransHomePage.clickOnBuyNowButton();
//        testBase.pauseExecution(2);
        Assert.assertTrue(shoppingCartPopUp.verifyUserIsOnCheckOutPopUp());
    }

    @Parameters({"ProductNameX" , "ProductCostX"})
    @Test(priority = 3 , groups = {"Regression"})
    public void VerifyMidtransPillowAddedInToCart (@Optional String productNameX , @Optional String productCostX) {

        Assert.assertTrue(shoppingCartPopUp.verifyProductAndPrice(productNameX , productCostX));
//        testBase.pauseExecution(2);
    }

    @Test(priority = 4 , groups = {"Regression"})
    public void verifyName_Email_Phone_City_Address_PostalCodeOnCheckoutPage () {

        Assert.assertTrue(shoppingCartPopUp.verifyLabelsOnCheckOutPopUp());
//        testBase.pauseExecution(2);
    }

    @Parameters({"NameX" , "EmailX" , "PhoneX" , "CityX" , "AddressX" , "PostalCodeX"})
    @Test(priority = 5 , groups = {"Regression"})
    public void verifyName_Email_Phone_City_Address_PostalCodeFieldsAreEditableAndUserCanEnterDetails (@Optional String nameX , @Optional String emailX , @Optional String phoneX , @Optional String cityX , @Optional String addressX ,@Optional String postalCodeX) {

        Assert.assertTrue(shoppingCartPopUp.verifyTextFieldsAreEditable(nameX , emailX , phoneX , cityX , addressX , postalCodeX));
//        testBase.pauseExecution(2);
    }

    @Test(priority = 6 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnCheckoutButtonUserIsRedirectedOnOrderSummaryPopUp () {

        shoppingCartPopUp.clickOnCheckOutButton();
//        testBase.pauseExecution(2);
        Assert.assertTrue(orderSummaryScreenPopUp.verifyUserIsOnOrderSummaryPopUp());
//        testBase.pauseExecution(2);
    }

    @Parameters({"ProductNameX" , "ProductCostX"})
    @Test(priority = 7 , groups = {"Regression"})
    public void verifyProductDetailsOnOrderSummeryPopUpPriceAndProductName (@Optional String productNameX , @Optional String productCostX) {

        Assert.assertTrue(orderSummaryScreenPopUp.verifyProductDetailsOnOrderSummaryPopUp(productNameX , productCostX));
//        testBase.pauseExecution(2);
    }

    @Test(priority = 8 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnContinueButtonOnOrderSummeryUserIsRedirectToTheSelectPaymentPopUp () {

        orderSummaryScreenPopUp.clickOnContinueButton();
        Assert.assertTrue(selectPaymentPopUp.verifyUserIsOnSelectPaymentPopUp());
//        testBase.pauseExecution(2);
    }

    @Test(priority = 9 , groups = {"Regression"})
    public void verifyPaymentOptionsListedOnPaymentPopUp () {

        Assert.assertTrue(selectPaymentPopUp.verifyPaymentModeOptions());
//        testBase.pauseExecution(2);
    }

    @Test(priority = 10 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnCreditDebitCardPaymentMethodUserIsRedirectedToTheCardDetailsPopUp () {

        selectPaymentPopUp.clickOnCreditDebitCardPaymentOption();
//        testBase.pauseExecution(2);
        Assert.assertTrue(creditDebitCardDetailsScreenPopUp.verifyUserIsOnCreditDebitCardDetailsPopUp());
//        testBase.pauseExecution(2);
    }

    @Parameters({"AmountBeforeApplyPromoX" , "AmountAfterApplyPromoX"})
    @Test(priority = 11 , groups = {"Regression"})
    public void verifyOrderAmountOnCardDetailsPopUpAndApplyCouponCodeAndValidateChangesInAmount (@Optional String amountBeforeApplyPromoX , @Optional String amountAfterApplyPromoX) {

        Assert.assertTrue(creditDebitCardDetailsScreenPopUp.verifyOrderAmountBeforeAndAfterApplyPromo(amountBeforeApplyPromoX , amountAfterApplyPromoX));
//        testBase.pauseExecution(2);
    }

    @Parameters({"CardNumberValX" , "ExpiryDateValX" , "CvvValX"})
    @Test(priority = 12 , groups = {"Regression" , "Smoke"})
    public void enterValidCardDetails (@Optional String cardNumberValX , @Optional String expiryDateValX , @Optional String cvvValX) {

        creditDebitCardDetailsScreenPopUp.enterCardDetails(cardNumberValX , expiryDateValX , cvvValX);
//        testBase.pauseExecution(2);
    }

    @Parameters({"ExpectedMerchantNameX" , "ExpectedAmountX" , "ExpectedCardNumberX" , "validOTPX"})
    @Test(priority = 13 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnPayNowButtonUserIsRedirectedToTheBankPaymentScreenPopUpAndVerifyExistingDetails (@Optional String expectedMerchantNameX , @Optional String expectedAmountX , @Optional String expectedCardNumberX , @Optional String validOTPX) {

        creditDebitCardDetailsScreenPopUp.clickOnPayNowButton();
        testBase.pauseExecution(2);
        Assert.assertTrue(bankPaymentScreenPopUp.verifyUserIsOnBankPaymentScreenPopUp());
        Assert.assertTrue(bankPaymentScreenPopUp.verifyDetailsOnBankPaymentScreen(expectedMerchantNameX , expectedAmountX , expectedCardNumberX));
        bankPaymentScreenPopUp.enterValidOTP(validOTPX);
//        testBase.pauseExecution(2);
    }

    @Parameters({"ExpectedFailedMessageX"})
    @Test(priority = 14 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnCancelButtonUserRedirectedToTheOrderFailedScreenPopUp (@Optional String expectedFailedMessageX) {

        bankPaymentScreenPopUp.clickOnCancelButton();
//        testBase.pauseExecution(2);
        Assert.assertTrue(orderFailedScreenPopUp.verifyUserIsOnOrderFailedScreenPopUp());
        testBase.pauseExecution(5);
    }

    @AfterTest
    public void closeBrowser() {

        baseClass.tearDown();
    }
}
