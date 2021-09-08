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
public class MidTransHomePage extends BaseClass{

    private static final Logger logger = LogManager.getLogger(MidTransHomePage.class);

    public MidTransHomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //coco logo
    @FindBy(xpath = "//a[contains(.,'Coco')]")
    WebElement logo;

    //Midtrans Pillow text with 20000 rs
    @FindBy(xpath = "//div[@class='title' and contains(.,'Midtrans Pillow')]")
    WebElement midtransPillow;
    @FindBy(xpath = "//div[@class='price']")
    WebElement rupees;

    //buy now button
    @FindBy(xpath = "//a[@class='btn buy']")
    WebElement buyNowButton;

    //verify transaction successful status
    @FindBy(xpath = "//div[@class='trans-status trans-success']/span[contains(.,'Thank you for your purchase.')]")
    WebElement transactionSuccessStatus;


    //verify logo of Coco
    public boolean verifyCocoLogo() {

        explicitWaitForVerifyingElement(driver , 40 , logo);
        boolean flag;
        logger.info("driver verifying Coco logo on midtrans Home Page : ");
        flag = logo.isDisplayed();
        if (flag) {

            logger.info("Coco logo on Midtrans Home Page is present : ");
        } else {

            logger.info("Coco logo on Midtrans Home Page is not present : ");
        }
        return flag;
    }

    //Verify Midtrans Pillow Cost
    public boolean verifyMidtransPillowCost(String productCostX) {

        boolean flag1;
        boolean flag2 = false;

        flag1 = midtransPillow.isDisplayed();
        if (productCostX==null) {

            String productCostP = prop.getProperty("productCost");
            if (rupees.getText().contains(productCostP)) {

                flag2 = true;
            }
        } else {

            if (rupees.getText().contains(productCostX)) {

                flag2 = true;
            }
        }
        boolean flag = flag1 && flag2;
        if (flag) {

            logger.info("Midtrans Pillow has added into cart with cost of 20000/- : ");
        } else {

            logger.info("Midtrans Pillow has not added into cart with cost of 20000/- : ");
        }
        return flag;
    }

    //verify the availability of buy now button
    public boolean checkAvailabilityOfBuyNowButton() {

        boolean flag = false;
        explicitWaitForVerifyingElement(driver , 50 , buyNowButton);
        if (buyNowButton.isDisplayed()) {

            flag = true;
            logger.info("Buy Now Button is Available on Midtrans Home Page : ");
        } else {

            logger.info("Buy Now Button is not Available on Midtrans Home Page : ");
        }
        return flag;
    }

    //Verify clicking on Buy Now button redirect user to checkout popup
    public ShoppingCartPopUp clickOnBuyNowButton () {

        explicitWaitForClick(driver , 50 , buyNowButton);
        return new ShoppingCartPopUp(driver);
    }

    //verify user purchase product successfully
    public boolean verifyTransactionSuccessStatus (String transactionSuccessStatusX) {

        pauseExecution(1);
        switchDefaultContent();
        pauseExecution(1);
        boolean flag = false;

        if (transactionSuccessStatus.isDisplayed()) {

            logger.info("Transaction Success Status is Displayed : ");
        } else {

            logger.info("Transaction Success Status is not Displayed : ");
        }
        if (transactionSuccessStatusX==null) {

            logger.info("Transaction Success Status is taking from Properties File : ");
            String transactionSuccessStatusP = prop.getProperty("transactionSuccessStatus");
            String getTransactionSuccessStatus = transactionSuccessStatus.getText();
            System.out.println(transactionSuccessStatusP);
            System.out.println(getTransactionSuccessStatus);
            if (getTransactionSuccessStatus.equalsIgnoreCase(transactionSuccessStatusP)) {

                flag = true;
                logger.info("Transaction Success Status is as Expected : ");
            } else {

                logger.info("Transaction Success Status is not as Expected : ");
            }
        } else {

            logger.info("Transaction Success Status is taking from .xml File : ");
            explicitWaitForVerifyingElement(driver , 40 , transactionSuccessStatus);
            String getTransactionSuccessStatus = transactionSuccessStatus.getText();
            if (getTransactionSuccessStatus.equalsIgnoreCase(transactionSuccessStatusX)) {

                flag = true;
                logger.info("Transaction Success Status is as Expected : ");
            } else {

                logger.info("Transaction Success Status is not as Expected : ");
            }
        }
        return flag;
    }
}
