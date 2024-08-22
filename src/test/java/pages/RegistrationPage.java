package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponents;
import pages.components.ResultTableComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public final SelenideElement firstNameInput = $("#firstName");
    public final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    public final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    public static SelenideElement stateInput = $("#state");
    public static SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");

    CalendarComponents calendarComponents = new CalendarComponents();
    ResultTableComponents resultTableComponents = new ResultTableComponents();

    @Step("Открытие страницы регистарци")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Убираем рекламу")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввод имени")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.scrollIntoView(true).setValue(firstName);
        return this;
    }

    @Step("Ввод фамилии")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.scrollIntoView(true).setValue(lastName);
        return this;
    }

    @Step("Ввод почты")
    public RegistrationPage setUserEmail(String email) {
        userEmailInput.scrollIntoView(true).setValue(email);
        return this;
    }

    @Step("Ввод номера телефона")
    public RegistrationPage setUserNumber(String phoneNumber) {
        userNumberInput.scrollIntoView(true).setValue(phoneNumber);
        return this;
    }

    @Step("Выбор гендера")
    public RegistrationPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).scrollIntoView(true).click();
        return this;
    }

    @Step("Ввод даты рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.scrollIntoView(true).click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    @Step("Выбор хобби")
    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).scrollIntoView(true).click();
        return this;
    }

    @Step("Загрузка картинки")
    public RegistrationPage uploadPicture(String picturePath) {
        uploadPictureInput.uploadFromClasspath(picturePath);
        return this;
    }

    @Step("Ввод адреса")
    public RegistrationPage setAddress(String address) {
        addressInput.scrollIntoView(true).setValue(address);
        return this;
    }

    @Step("Ввод {subject}")
    public RegistrationPage setSubject(String subject) {
        subjectsInput.scrollIntoView(true).setValue(subject).pressEnter();
        return this;
    }

    @Step("Ввод штата")
    public RegistrationPage setState(String state) {
        stateInput.scrollIntoView(true).click();
        stateInput.$(byText(state)).click();
        return this;
    }

    @Step("Ввод города")
    public RegistrationPage setCity(String city) {
        cityInput.scrollIntoView(true).click();
        cityInput.$(byText(city)).click();
        return this;
    }

    @Step("Клик на кнопку Отправить")
    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Проверка красного бордера")
    public RegistrationPage checkFieldBorderColor(SelenideElement locatorId, String color) {
        locatorId.shouldHave(Condition.cssValue("border-color", color));
        return this;
    }

    @Step("Проверка результатов")
    public RegistrationPage checkResult(String key, String value) {
        resultTableComponents.checkResult(key, value);
        return this;
    }
}
