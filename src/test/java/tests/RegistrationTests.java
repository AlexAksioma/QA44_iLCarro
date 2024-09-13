package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        String email = "frodo_baggins" + i + "@gmail.com";
        new HomePage(getDriver())
                .clickBtnRegistration()
                .typeRegistrationForm("Alex", "Med", email, "Qwerty123!")
        ;
    }
}
