package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_LoginSuccess;

    public LoginPage typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickBtnYalla() {
        pause(3);
        btnYalla.click();
        return this;
    }

    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(textPopUp_LoginSuccess, "Logged in success");
    }
}
