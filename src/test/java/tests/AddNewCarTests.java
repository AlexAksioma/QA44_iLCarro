package tests;

import dto.CarDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.Fuel;
import utils.HeaderMenuItem;

import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {

    LetTheCarWorkPage letTheCarWorkPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startAddCar() {
        new HomePage(getDriver());
        loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm("alexmed123@gmail.com", "Qwerty123!")
                .clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest() {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1222-"+new Random().nextInt(1000))
                .pricePerDay(1000)
                .about("text")
                .image("qa_yellow.png")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.clickBtnSubmit();
        Assert.assertTrue(letTheCarWorkPage.validatePopUpMessage
                (car.getManufacture()+" "+car.getModel()+" added successful"));
    }
}
