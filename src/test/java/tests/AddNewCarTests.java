package tests;

import dto.CarDto;
import manager.ApplicationManager;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.Fuel;
import utils.HeaderMenuItem;

import java.lang.reflect.Method;
import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {

    LetTheCarWorkPage letTheCarWorkPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startAddCar() {
        logger.info("start method --> startAddCar"+" user: alexmed123@gmail.com");
        new HomePage(getDriver());
        loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm("alexmed123@gmail.com", "Qwerty123!")
                .clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest(Method method) {
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
        logger.info("start --> "+method.getName()+"with data: "+car.toString());
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.clickBtnSubmit();
        Assert.assertTrue(letTheCarWorkPage.validatePopUpMessage
                (car.getManufacture()+" "+car.getModel()+" added successful"));
    }
}
