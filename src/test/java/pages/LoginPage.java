package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[text()=\"Account\"])[1]")
    private WebElement AccountBtn;

    @FindBy(xpath = "//input[@id=\"loginFrm_loginname\"]")
    private WebElement Username;

    @FindBy(xpath = "//input[@id=\"loginFrm_password\"]")
    private WebElement Password;

    @FindBy(xpath = "//button[@title=\"Login\"]")
    private WebElement LoginBtn;

    public void Login(String name, String pass)
    {
        AccountBtn.click();
        Username.sendKeys(name);
        Password.sendKeys(pass);
        LoginBtn.click();
    }

}
