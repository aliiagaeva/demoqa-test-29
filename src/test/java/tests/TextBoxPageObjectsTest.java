package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponents;


public class TextBoxPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("smoke")
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Name")
                .setLastName("Last")
                .setUserNumber("1234567890")
                .selectGender("Female")
                .setDateOfBirth("30", "January", "1991")
                .submitForm()
                .checkResult("Student Name", "Name Last")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 January,1991");
    }

    @Test
    @Tag("smoke")
    void negativeRegistrationTest() {
        String redColor = "rgb(220, 53, 69)";
        registrationPage.openPage()
                .setUserNumber("123456789")
                .selectGender("Female")
                .submitForm()
                .checkFieldBorderColor(registrationPage.firstNameInput, redColor)
                .checkFieldBorderColor(registrationPage.lastNameInput, redColor)
                .checkFieldBorderColor(registrationPage.userNumberInput, redColor);
        new ResultTableComponents().checkResultsTableNotVisible();// добавила проверку что не открывается попап с результатами
    }

    @Test
    @Tag("regression")
    void successfulFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Last")
                .setUserEmail("Name@gmail.com")
                .setUserNumber("1234567890")
                .selectGender("Female")
                .setDateOfBirth("30", "January", "1991")
                .setHobbies("Sports")
                .uploadPicture("1000.jpg")
                .setAddress("SPb")
                .setSubject("Math")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm()
                .checkResult("Student Name", "Name Last")
                .checkResult("Student Email", "Name@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 January,1991")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1000.jpg")
                .checkResult("Address", "SPb")
                .checkResult("State and City", "Rajasthan Jaipur");
    }
}
