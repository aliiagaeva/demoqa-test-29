package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.ResultTableComponents;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public final SelenideElement firstNameInput = $("#firstName");
    public final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    public final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement hobbyCheckbox(String hobby) { return $("label[for='hobbies-checkbox-" + hobby + "']"); }
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement stateDropdown = $("#state");
    private SelenideElement stateOption(String state) { return $("#react-select-3-option-" + state); }
    private final SelenideElement cityDropdown = $("#city");
    private SelenideElement cityOption(String city) { return $("#react-select-4-option-" + city); }
    private final SelenideElement submitButton = $("#submit");

    CalendarComponents calendarComponents = new CalendarComponents();
    ResultTableComponents resultTableComponents = new ResultTableComponents();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }
    public RegistrationPage setUserNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }
    public RegistrationPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }
    public RegistrationPage selectHobbies(String hobby) {
        hobbyCheckbox(hobby).click();
        return this;
    }
    public RegistrationPage uploadPicture(String picturePath) {
        uploadPictureInput.uploadFromClasspath(picturePath);
        return this;
    }
    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }
    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage setState(String state) {
        stateDropdown.click();
        stateOption(state).click();
        return this;
    }
    public RegistrationPage setCity(String city) {
        cityDropdown.click();
        cityOption(city).click();
        return this;
    }
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkFieldBorderColor(SelenideElement locatorId, String color) {
        locatorId.shouldHave(Condition.cssValue("border-color", color));
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        resultTableComponents.checkResult(key, value);
        return this;
    }
}
