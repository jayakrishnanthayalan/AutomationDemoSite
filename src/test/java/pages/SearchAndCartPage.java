package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchAndCartPage {

    private WebDriver driver;

    public SearchAndCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()=\"Cart\"]")
    private WebElement ComAddToCartBtn;

    @FindBy(id = "filter_keyword")
    private WebElement searchBox;

    @FindBy(xpath = "//a[@class='cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[text()='Casual 3/4 Sleeve Baseball T-Shirt']")
    private WebElement baseballTShirtProduct;

    @FindBy(xpath = "//a[@title='Shaving cream']")
    private WebElement shavingCreamProduct;

    @FindBy(xpath = "(//a[@class=\"btn btn-sm btn-default\"])[2]")
    private WebElement RemoveFromCart;

    @FindBy(xpath = "//img[@title=\"Automation Test Store\"]")
    private WebElement reload;

    @FindBy(xpath = "//a[@id=\"cart_checkout1\"]")
    private WebElement CheckOutBtn;

    @FindBy(xpath = "//button[@id=\"checkout_btn\"]")
    private WebElement ConfirmOrderBtn;

    @FindBy(xpath = "//span[contains(text(),\"Your Order Has Been Processed!\")]")
    private WebElement VerifyOrder;


    public void searchForProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void addToCartBtn(){ComAddToCartBtn.click();}

    public void selectBaseballTShirtProduct() {
        baseballTShirtProduct.click();
    }

    public void selectShavingCreamProduct() {
        shavingCreamProduct.click();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void removeFromCart(){RemoveFromCart.click();}

    public void Reload(){reload.click();}

    public void Checkout(String OrderVerify){
        CheckOutBtn.click();
        ConfirmOrderBtn.click();
        System.out.println("Expected Result: YOUR ORDER HAS BEEN PROCESSED!");
        System.out.println("Actual Result: "+VerifyOrder.getText());
        Assert.assertTrue(OrderVerify.contains(VerifyOrder.getText()), "Account creation confirmation message mismatch");
    }
}
