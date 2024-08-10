package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

@Tag("regression")
public class RegistrationWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    String state = testData.getState;
    String city = testData.getCityForState(state);

    @Test
    void successfulFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserNumber(testData.phoneNumber)
                .selectGender(testData.gender)
                .setDateOfBirth(testData.getDay(), testData.getMonth(), testData.getYear())
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setAddress(testData.streetAddress)
                .setSubject(testData.subjects)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.getDay() + " " + testData.getMonth() + "," + testData.getYear())
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", state + " " + city);
    }
}
