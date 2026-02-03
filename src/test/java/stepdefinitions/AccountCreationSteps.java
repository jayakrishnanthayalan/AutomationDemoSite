package stepdefinitions;

import io.cucumber.java.en.*;
import pages.AccountCreationPage;
import utils.DriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.TestDataGenerator;
import utils.JsonUtil;

public class AccountCreationSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final AccountCreationPage accountPage = new AccountCreationPage(driver);


    @Given("the user navigates to the account creation page")
    public void navigateToAccountCreationPage() {
        accountPage.navigateToAccountCreation();
    }

    @And("the user is on the account creation page")
    public void verifyAccountCreationPage() {
        String CreateAccountMsg=accountPage.VerifyCreateAccount();
        System.out.println("Expected text: CREATE ACCOUNT");
        System.out.println("Actual text: "+CreateAccountMsg);
        Assert.assertTrue(CreateAccountMsg.contains("CREATE ACCOUNT"), "User is not on Account Creation page");
    }

    @When("the user enters valid account details")
    public void enterAccountDetails() {
        JsonUtil.writeValue("Username",TestDataGenerator.USERNAME);
        JsonUtil.writeValue("MailID",TestDataGenerator.EMAIL);
        accountPage.enterPersonalDetails(TestDataGenerator.FIRST_NAME, TestDataGenerator.LAST_NAME, JsonUtil.readValue("MailID"));

        accountPage.enterAddressDetails("Test Address Line 1", "Bangalore", "560001");

        accountPage.selectCountry("India");
        accountPage.selectState("Karnataka");


        accountPage.setCredentials(JsonUtil.readValue("Username"), TestDataGenerator.PASSWORD);

        accountPage.acceptPrivacyPolicy();
        accountPage.submitRegistration();
    }

    @Then("the account should be created successfully")
    public void verifyAccountCreation() {

        String successText = accountPage.VerifyAccountCreation();
        Assert.assertTrue(successText.contains("Welcome back"), "Account creation confirmation message mismatch");
    }
}
