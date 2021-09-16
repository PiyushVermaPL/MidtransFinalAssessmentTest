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
public class ShoppingCartPopUp extends BaseClass {

    private static final Logger logger = LogManager.getLogger(ShoppingCartPopUp.class);

    public ShoppingCartPopUp(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    //shopping cart popup
    @FindBy(xpath = "//div[@class='cart-head']/span[contains(.,'Shopping Cart')]")
    WebElement shoppingCartPopUp;

    //product
    @FindBy(xpath = "//tr[@class='table-content']//td[contains(.,'Midtrans Pillow')]")
    WebElement product;

    //product cost
    @FindBy(xpath = "//td[@class='amount']")
    WebElement cost;

    //name label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'Name')]")
    WebElement nameLabel;
    //name textField
    @FindBy(xpath = "((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[1]")
    WebElement nameTextField;

    //email label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'Email')]")
    WebElement emailLabel;
    //email Text field
    @FindBy(xpath = "(//table[@class='table'])[2]//td[@class='input']//input[@type='email']")
    WebElement emailTextField;

    //phoneNo label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'Phone no')]")
    WebElement phoneNoLabel;
    //phoneNo Text field
    @FindBy(xpath = "((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[2]")
    WebElement phoneNoTextField;

    //city label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'City')]")
    WebElement cityLabel;
    //city Text field
    @FindBy(xpath = "((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[3]")
    WebElement cityTextField;

    //address label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'Address')]")
    WebElement addressLabel;
    //address Text field
    @FindBy(xpath = "(//table[@class='table'])[2]//td[@class='input']//textarea")
    WebElement addressTextField;

    //postal Code label
    @FindBy(xpath = "(//table[@class='table'])[2]//td[contains(.,'Postal Code')]")
    WebElement postalCodeLabel;
    //postalCode Text field
    @FindBy(xpath = "((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[4]")
    WebElement postalCodeTextField;

    //checkout Button
    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement checkOut;

    //cancel Button
    @FindBy(xpath = "//div[@class='cancel-btn']")
    WebElement cancelButton;

    //Verify clicking on Buy Now button redirect user to the CheckOut popup
    public boolean verifyUserIsOnCheckOutPopUp() {

        explicitWaitForVerifyingElement(driver , 40 , shoppingCartPopUp);
        boolean flag = false;

        if (shoppingCartPopUp.isDisplayed()) {

            logger.info("After clicking on Buy Now button user is redirected to the Checkout popup : ");
            flag = true;
        }
        return flag;
    }

    //Verify "Midtrans Pillow" has added into cart with cost of 20000/-
    public boolean verifyProductAndPrice(String productNameX , String productCostX) {

        boolean flag1 = false;
        boolean flag2 = false;

        if (productNameX==null || productCostX==null) {

            logger.info("Product Name & Product Cost is taking from Properties File : ");
            String productName = prop.getProperty("productName");
            String productCost = prop.getProperty("productCost");

            if (product.getText().equalsIgnoreCase(productName)) {

                flag1 = true;
            }
            if (cost.getText().equalsIgnoreCase(productCost)) {

                flag2 = true;
            }
        } else {

            logger.info("Product Name & Product Cost is taking from .xml File : ");
            if (product.getText().equalsIgnoreCase(productNameX)) {

                flag1 = true;
            }
            if (cost.getText().equalsIgnoreCase(productCostX)) {

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

    //Verify Name, email, phone, city, Address, postal code on checkout page
    public boolean verifyLabelsOnCheckOutPopUp() {

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;

        if (nameLabel.isDisplayed()) {

            flag1 = true;
            logger.info("Name Label is Present on Check Out PopUp : ");
        } else {

            logger.info("Name Label is not Present on Check Out PopUp : ");
        }

        if (emailLabel.isDisplayed()) {

            flag2 = true;
            logger.info("Email Label is Present on Check Out PopUp : ");
        } else {

            logger.info("Email Label is not Present on Check Out PopUp : ");
        }

        if (phoneNoLabel.isDisplayed()) {

            flag3 = true;
            logger.info("PhoneNo Label is Present on Check Out PopUp : ");
        } else {

            logger.info("PhoneNo Label is not Present on Check Out PopUp : ");
        }

        if (cityLabel.isDisplayed()) {

            flag4 = true;
            logger.info("City Label is Present on Check Out PopUp : ");
        } else {

            logger.info("City Label is not Present on Check Out PopUp : ");
        }

        if (addressLabel.isDisplayed()) {

            flag5 = true;
            logger.info("Address Label is Present on Check Out PopUp : ");
        } else {

            logger.info("Address Label is not Present on Check Out PopUp : ");
        }

        if (postalCodeLabel.isDisplayed()) {

            flag6 = true;
            logger.info("PostalCode Label is Present on Check Out PopUp : ");
        } else {

            logger.info("PostalCode Label is not Present on Check Out PopUp : ");
        }
        return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
    }

    //Verify Name, email, phone, city, Address, postal code fields are editable and user can enter details in it
    public boolean verifyTextFieldsAreEditable (String nameX , String emailX , String phoneX , String cityX , String addressX , String postalCodeX) {

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;

        if (nameX==null) {

            logger.info("Name is taking from Properties File : ");
            String name = prop.getProperty("name");
            explicitWaitForSenKeys(driver , 50 , nameTextField , name);
            String getNameVal = nameTextField.getAttribute("value");
            if (getNameVal.equalsIgnoreCase(name)) {

                flag1 = true;
                logger.info("Name field is editable and user can enter Name in it : ");
            } else {

                logger.info("Name field is not editable and user can not enter Name in it : ");
            }
        } else {

            explicitWaitForSenKeys(driver , 50 , nameTextField , nameX);
            logger.info("Name is taking from .xml File : ");
            String getNameVal = nameTextField.getAttribute("value");
            if (getNameVal.equalsIgnoreCase(nameX)) {

                flag1 = true;
                logger.info("Name field is editable and user can enter Name in it : ");
            } else {

                logger.info("Name field is not editable and user can not enter Name in it : ");
            }
        }

        if (emailX==null) {

            logger.info("Email is taking from Properties File : ");
            String email = prop.getProperty("email");
            explicitWaitForSenKeys(driver , 40 , emailTextField , email);
            String getEmailVal = emailTextField.getAttribute("value");
            if (getEmailVal.equalsIgnoreCase(email)) {

                flag2 = true;
                logger.info("Email field is editable and user can enter Email in it : ");
            } else {

                logger.info("Email field is not editable and user can not enter Email in it : ");
            }
        } else {

            logger.info("Email is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , emailTextField , emailX);
            String getEmailVal = emailTextField.getAttribute("value");
            if (getEmailVal.equalsIgnoreCase(emailX)) {

                flag2 = true;
                logger.info("Email field is editable and user can enter Email in it : ");
            } else {

                logger.info("Email field is not editable and user can not enter Email in it : ");
            }
        }

        if (phoneX==null) {

            logger.info("Phone Number is taking from Properties File : ");
            String phone = prop.getProperty("phoneNo");
            explicitWaitForSenKeys(driver , 40 , phoneNoTextField , phone);
            String getPhoneNoVal = phoneNoTextField.getAttribute("value");
            if (getPhoneNoVal.equalsIgnoreCase(phone)) {

                flag3 = true;
                logger.info("PhoneNo field is editable and user can enter PhoneNo in it : ");
            } else {

                logger.info("PhoneNo field is not editable and user can not enter PhoneNo in it : ");
            }
        } else {

            logger.info("Phone Number is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , phoneNoTextField , phoneX);
            String getPhoneNoVal = phoneNoTextField.getAttribute("value");
            if (getPhoneNoVal.equalsIgnoreCase(phoneX)) {

                flag3 = true;
                logger.info("PhoneNo field is editable and user can enter PhoneNo in it : ");
            } else {

                logger.info("PhoneNo field is not editable and user can not enter PhoneNo in it : ");
            }
        }

        if (cityX==null) {

            logger.info("City is taking from Properties File : ");
            String city = prop.getProperty("city");
            explicitWaitForSenKeys(driver , 40 , cityTextField , city);
            String getCityVal = cityTextField.getAttribute("value");
            if (getCityVal.equalsIgnoreCase(city)) {

                flag4 = true;
                logger.info("City field is editable and user can enter City in it : ");
            } else {

                logger.info("City field is not editable and user can not enter City in it : ");
            }
        } else {

            logger.info("City is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , cityTextField , cityX);
            String getCityVal = cityTextField.getAttribute("value");
            if (getCityVal.equalsIgnoreCase(cityX)) {

                flag4 = true;
                logger.info("City field is editable and user can enter City in it : ");
            } else {

                logger.info("City field is not editable and user can not enter City in it : ");
            }
        }

        if (addressX==null) {

            logger.info("Address is taking from Properties File : ");
            String address = prop.getProperty("address");
            explicitWaitForSenKeys(driver , 40 , addressTextField , address);
            String getAddressVal = addressTextField.getAttribute("value");
            if (getAddressVal.equalsIgnoreCase(address)) {

                flag5 = true;
                logger.info("Address field is editable and user can enter Address in it : ");
            } else {

                logger.info("Address field is not editable and user can not enter Address in it : ");
            }
        } else {

            logger.info("Address is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , addressTextField , addressX);
            String getAddressVal = addressTextField.getAttribute("value");
            if (getAddressVal.equalsIgnoreCase(addressX)) {

                flag5 = true;
                logger.info("Address field is editable and user can enter Address in it : ");
            } else {

                logger.info("Address field is not editable and user can not enter Address in it : ");
            }
        }

        if (postalCodeX==null) {

            logger.info("Postal Code is taking from Properties File : ");
            String postalCode = prop.getProperty("postalCode");
            explicitWaitForSenKeys(driver , 40 , postalCodeTextField , postalCode);
            String getPostalVal = postalCodeTextField.getAttribute("value");
            if (getPostalVal.contentEquals(postalCode)) {

                flag6 = true;
                logger.info("PostalCode field is editable and user can enter PostalCode in it : ");
            } else {

                logger.info("PostalCode field is not editable and user can not enter PostalCode in it : ");
            }
        } else {

            logger.info("Postal Code is taking from .xml File : ");
            explicitWaitForSenKeys(driver , 40 , postalCodeTextField , postalCodeX);
            String getPostalVal = postalCodeTextField.getAttribute("value");
            if (getPostalVal.contentEquals(postalCodeX)) {

                flag6 = true;
                logger.info("PostalCode field is editable and user can enter PostalCode in it : ");
            } else {

                logger.info("PostalCode field is not editable and user can not enter PostalCode in it : ");
            }
        }

        return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
    }

    //clicking on Checkout button
    public OrderSummaryScreenPopUp clickOnCheckOutButton() {

        explicitWaitForClick(driver , 40 , checkOut);
        return new OrderSummaryScreenPopUp(driver);
    }

    //clicking on CancelButton
    public MidTransHomePage clickOnCancelButton() {

        explicitWaitForClick(driver , 40 , cancelButton);
        return new MidTransHomePage(driver);
    }
}
