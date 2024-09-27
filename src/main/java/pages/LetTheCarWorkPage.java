package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class LetTheCarWorkPage extends BasePage{
    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(id = "pickUpPlace")
    WebElement inputLocation;
    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement inputFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(id = "about")
    WebElement inputAbout;
    @FindBy(id = "photos")
    WebElement inputPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='dialog-container']/h2")
    WebElement messageSuccessAddCar;

    public void typeAddNewCarForm(CarDto car) {
        inputLocation.sendKeys(car.getCity());
        //pause(2);
        //driver.findElement(By.xpath("//div[@class='pac-item']")).click();
        clickWait(By.xpath("//div[@class='pac-item']"), 10);
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        //-----------------------------
        inputFuel.click();
        clickWait(By.xpath(car.getFuel()), 3);
        //-----------------------------
        inputSeats.sendKeys(car.getSeats()+"");
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(Double.toString(car.getPricePerDay()));
        inputAbout.sendKeys(car.getAbout());
        //-----------------------------
        File file = new File("src/test/resources/"+car.getImage());
        //System.out.println(file.getAbsolutePath());
        inputPhoto.sendKeys(file.getAbsolutePath());
    }

    public void clickBtnSubmit(){
        clickWait(btnSubmit, 3);
    }
    public boolean validatePopUpMessage(String text){
        return isTextInElementPresent(messageSuccessAddCar, text);
    }
}
