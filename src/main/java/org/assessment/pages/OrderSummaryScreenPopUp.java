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

public class OrderSummaryScreenPopUp extends BaseClass {

    private static final Logger logger = LogManager.getLogger(OrderSummaryScreenPopUp.class);

    public OrderSummaryScreenPopUp(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //order Summary
    @FindBy(xpath = "//div[@class='header-content']/span[contains(.,'Order Summary')]")
    WebElement orderSummary;

    //items
    @FindBy(xpath = "(//table[@class='table']//tr)[2]/td[1]")
    WebElement item;

    //price
    @FindBy(xpath = "(//table[@class='table']//tr)[2]/td[2]")
    WebElement price;

    //continue Button
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement continueButton;

    //verifying orderSummary PopUp
    public boolean verifyUserIsOnOrderSummaryPopUp() {

        explicitWaitForVerifyingElement(driver , 40 , orderSummary);
        //driver.switchTo().frame(0);
        boolean flag = false;
        if (orderSummary.isDisplayed()) {

            flag = true;
            logger.info("User is redirected on Order Summary popup after clicked on Checkout button : ");
        } else {

            logger.info("User is not redirected on Order Summary popup after clicked on Checkout button : ");
        }
        return flag;
    }

    //Verify all the product details on order summery popup - price, product name
    public boolean verifyProductDetailsOnOrderSummaryPopUp (String productNameX , String productCostX) {

        boolean flag1 = false;
        boolean flag2 = false;

        if (productNameX==null || productCostX==null) {

            logger.info("Product Name & Product Cost is taking from Properties File : ");
            String itemName  = prop.getProperty("productName");
            String itemPrice = prop.getProperty("productCost");

            if (item.getText().equalsIgnoreCase(itemName)) {

                flag1 = true;
                logger.info("Valid Product Name is displayed on Order Summary PopUp : ");
            } else {

                logger.info("Valid Product Name is not displayed on Order Summary PopUp : ");
            }

            if (price.getText().equalsIgnoreCase(itemPrice)) {

                flag2 = true;
                logger.info("Valid Product Price is displayed on Order Summary PopUp : ");
            } else {

                logger.info("Valid Product Price is not displayed on Order Summary PopUp : ");
            }
        } else {

            logger.info("Product Name & Product Cost is taking from .xml File : ");

            if (item.getText().equalsIgnoreCase(productNameX)) {

                flag1 = true;
                logger.info("Valid Product Name is displayed on Order Summary PopUp : ");
            } else {

                logger.info("Valid Product Name is not displayed on Order Summary PopUp : ");
            }

            if (price.getText().equalsIgnoreCase(productCostX)) {

                flag2 = true;
                logger.info("Valid Product Price is displayed on Order Summary PopUp : ");
            } else {

                logger.info("Valid Product Price is not displayed on Order Summary PopUp : ");
            }
        }

        return flag1 && flag2;
    }

    //Click on Continue Button
    public SelectPaymentPopUp1 clickOnContinueButton () {

        explicitWaitForClick(driver , 30 , continueButton);
        return new SelectPaymentPopUp1(driver);
    }
}
