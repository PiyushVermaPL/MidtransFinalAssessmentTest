package org.assessment;

import org.assessment.pages.*;
import org.assessment.utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * @author verma.piyush
 */
@Listeners(org.assessment.utils.TestNGListener.class)
public class MidtransFinalAssessmentValidOTP {

    WebDriver driver;
    TestBase testBase = new TestBase();
    BaseClass baseClass;
    MidTransHomePage midTransHomePage;
    ShoppingCartPopUp shoppingCartPopUp;
    OrderSummaryScreenPopUp orderSummaryScreenPopUp;
    SelectPaymentPopUp1 selectPaymentPopUp;
    CreditDebitCardDetailsScreenPopUp creditDebitCardDetailsScreenPopUp;
    BankPaymentScreenPopUp bankPaymentScreenPopUp;
    OrderSuccessfulScreenPopUp orderSuccessfulScreenPopUp;

    public void  _init() {

        baseClass = new BaseClass(driver);
        midTransHomePage = new MidTransHomePage(driver);
        shoppingCartPopUp = new ShoppingCartPopUp(driver);
        orderSummaryScreenPopUp = new OrderSummaryScreenPopUp(driver);
        selectPaymentPopUp = new SelectPaymentPopUp1(driver);
        creditDebitCardDetailsScreenPopUp = new CreditDebitCardDetailsScreenPopUp(driver);
        bankPaymentScreenPopUp = new BankPaymentScreenPopUp(driver);
        orderSuccessfulScreenPopUp = new OrderSuccessfulScreenPopUp(driver);
    }

    @Parameters({"BrowserNameX"})
    @BeforeTest()
    public void openBrowser (@Optional String browserNameX) {

        driver = testBase.initializingBrowser (browserNameX);
        _init();
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

    @Parameters({"ExpectedMerchantNameX" , "ExpectedAmountX" , "ExpectedCardNumberX" , "ValidOTPX"})
    @Test(priority = 13 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnPayNowButtonUserIsRedirectedToTheBankPaymentScreenPopUpAndVerifyExistingDetails (@Optional String expectedMerchantNameX , @Optional String expectedAmountX , @Optional String expectedCardNumberX , @Optional String validOTPX) {

        creditDebitCardDetailsScreenPopUp.clickOnPayNowButton();
        testBase.pauseExecution(2);
        Assert.assertTrue(bankPaymentScreenPopUp.verifyUserIsOnBankPaymentScreenPopUp());
        Assert.assertTrue(bankPaymentScreenPopUp.verifyDetailsOnBankPaymentScreen(expectedMerchantNameX , expectedAmountX , expectedCardNumberX));
        bankPaymentScreenPopUp.enterValidOTP(validOTPX);
//        testBase.pauseExecution(2);
    }

    @Parameters({"ExpectedTransactionSuccessfulMessageX"})
    @Test(priority = 14 , groups = {"Regression" , "Smoke"})
    public void verifyClickingOnOKButtonWithValidOTPUserRedirectedToTheOrderSuccessfulScreenPopUp (@Optional String expectedTransactionSuccessfulMessageX) {

        bankPaymentScreenPopUp.clickOnOkButtonForOrderSuccessfulScreenPopUp();
        Assert.assertTrue(orderSuccessfulScreenPopUp.verifyUserIsOnOrderSuccessfulScreenPopUp());
        //Assert.assertTrue(orderSuccessfulScreenPopUp.verifyPaymentSuccessfulMsg(expectedTransactionSuccessfulMessageX));
        //Assert.assertTrue(orderSuccessfulScreenPopUp.verifyUserIsOnOrderSuccessfulScreenPopUpByIcon());
        //Assert.assertTrue(orderSuccessfulScreenPopUp.verifyUserIsOnOrderSuccessfulScreenPopUpByByDoneButton());
        testBase.pauseExecution(5);
    }

    @Parameters({"TransactionSuccessStatusX"})
    @Test(priority = 15 , groups = {"Regression"})
    public void verifyUserSuccessfullyOrderedProduct (@Optional String transactionSuccessStatusX) {

        testBase.setZoomLevelDecrease(2);
//        testBase.pauseExecution(2);
        Assert.assertTrue(midTransHomePage.verifyTransactionSuccessStatus(transactionSuccessStatusX));
        testBase.pauseExecution(5);
    }

    @AfterTest
    public void closeBrowser() {

        baseClass.tearDown();
    }
}
