package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;


    public RegistrationPage typeRegistrationForm(String name, String lastName, String email, String password) {
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }
}
