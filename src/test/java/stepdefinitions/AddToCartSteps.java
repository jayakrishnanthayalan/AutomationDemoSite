package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.SearchAndCartPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import utils.JsonUtil;
import utils.TestDataGenerator;

public class AddToCartSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final SearchAndCartPage searchPage = new SearchAndCartPage(driver);
    private final LoginPage loginPage=new LoginPage(driver);

    @Given("the user able to login")
    public void login(){
        loginPage.Login(JsonUtil.readValue("Username"),TestDataGenerator.PASSWORD);
    }

    @When("the user searches for a product")
    public void searchForProduct() {
        searchPage.searchForProduct("shirt");
    }

    @And("the user selects the baseball t-shirt product")
    public void selectBaseballTShirtProduct() {
        searchPage.selectBaseballTShirtProduct();
        searchPage.addProductToCart();
    }

    @And("the user selects the book")
    public void SelectBook(){
        searchPage.searchForProduct("Book");
        searchPage.addProductToCart();
    }

    @And("the user selects the shaving cream product")
    public void selectShavingCreamProduct() {
        searchPage.searchForProduct("cream");
        searchPage.selectShavingCreamProduct();
        searchPage.addProductToCart();
    }

    @And("the user reload the page")
    public void reload()
    {
        searchPage.Reload();
    }

    @And("the user click the Add to Cart Button")
    public void addToCartBtn(){
        searchPage.addToCartBtn();
    }

    @And("the user remove item from Cart")
    public void RemoveItem(){
        searchPage.removeFromCart();
    }

    @Then("the user able to Checkout the order")
    public void Checkout()
    {
        searchPage.Checkout("YOUR ORDER HAS BEEN PROCESSED!");
    }

}
