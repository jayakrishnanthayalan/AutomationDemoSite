package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {

    private final WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//span[text()='Account'])[1]")
    private WebElement accountButton;

    @FindBy(xpath = "//button[@title='Continue']")
    private WebElement continueButton;

    @FindBy(id = "AccountFrm_firstname")
    private WebElement firstName;

    @FindBy(id = "AccountFrm_lastname")
    private WebElement lastName;

    @FindBy(id = "AccountFrm_email")
    private WebElement email;

    @FindBy(id = "AccountFrm_address_1")
    private WebElement address1;

    @FindBy(id = "AccountFrm_country_id")
    private WebElement countryDropdown;

    @FindBy(id = "AccountFrm_city")
    private WebElement city;

    @FindBy(id = "AccountFrm_zone_id")
    private WebElement stateDropdown;

    @FindBy(id = "AccountFrm_postcode")
    private WebElement postcode;

    @FindBy(id = "AccountFrm_loginname")
    private WebElement username;

    @FindBy(id = "AccountFrm_password")
    private WebElement password;

    @FindBy(id = "AccountFrm_confirm")
    private WebElement confirmPassword;

    @FindBy(id = "AccountFrm_agree")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//button[@title='Continue']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"menu_text\"]")
    private WebElement verifyAccountCreation;

    @FindBy(xpath = "//span[@class='maintext']")
    private WebElement VerifyCreateAccount;


    public void navigateToAccountCreation() {
        accountButton.click();
        continueButton.click();
    }

    public void enterPersonalDetails(String fName, String lName, String mail) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
    }

    public void enterAddressDetails(String addr, String cityName, String pin) {
        address1.sendKeys(addr);
        city.sendKeys(cityName);
        postcode.sendKeys(pin);
    }

    public void selectCountry(String country) {
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void selectState(String state) {
        new Select(stateDropdown).selectByVisibleText(state);
    }

    public void setCredentials(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
    }

    public void acceptPrivacyPolicy() {
        if (!privacyPolicyCheckbox.isSelected()) {
            privacyPolicyCheckbox.click();
        }
    }

    public void submitRegistration() {
        submitButton.click();
    }

    public String VerifyAccountCreation(){
        return verifyAccountCreation.getText();
    }

    public String VerifyCreateAccount(){
        return  VerifyCreateAccount.getText().trim();
    }
}
