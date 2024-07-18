package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Last")
                .setUserNumber("1234567890")
                .selectGender("2")
                .setDateOfBirth("1", "January", "1970")
                .submitForm()
                .getResultTable()
                .checkResult("Student Name", "Name Last")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "01 January,1970");
              }

    @Test
    void negativeRegistrationTest() {
        String redColor = "rgb(220, 53, 69)";
        registrationPage.openPage()
                .setUserNumber("123456789")
                .selectGender("2")
                .submitForm()
                .checkFieldBorderColor(registrationPage.firstNameInput, redColor)
                .checkFieldBorderColor(registrationPage.lastNameInput, redColor)
                .checkFieldBorderColor(registrationPage.userNumberInput, redColor)
                .resultTableNotVisible(); // добавила проверку что не открывается попап с результатами
         }

    @Test
    void successfulFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Last")
                .setUserEmail("Name@gmail.com")
                .setUserNumber("1234567890")
                .selectGender("2")
                .setDateOfBirth("1", "January", "1970")
                .selectHobbies("1")
                .uploadPicture("1000.png")
                .setAddress("SPb")
                .setSubject("Math")
                .setState("3")
                .setCity("0")
                .submitForm();
        registrationPage.getResultTable()
                .checkResult("Student Name", "Name Last")
                .checkResult("Student Email", "Name@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "01 January,1970")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1000.jpg")
                .checkResult("Address", "SPb")
                .checkResult("State and City", "Rajasthan Jaipur");
    }
}
