package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests
{
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Last");
        $("#userEmail").setValue("Name@gmail.com");
        $("#userNumber").setValue("1234567890");
        $("label[for='gender-radio-2']").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1970");
        $(".react-datepicker__day--001").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("1000.jpg");
        $("#currentAddress").setValue("SPb");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $(".table").shouldHave(text("Student Name Name Last"));
        $(".table").shouldHave(text("Student Email Name@gmail.com"));
        $(".table").shouldHave(text("Gender Female"));
        $(".table").shouldHave(text("Mobile 1234567890"));
        $(".table").shouldHave(text("Date of Birth 01 January,1970"));
        $(".table").shouldHave(text("Subjects Maths"));
        $(".table").shouldHave(text("Hobbies Sports"));
        $(".table").shouldHave(text("Picture 1000.jpg"));
        $(".table").shouldHave(text("Address SPb"));
        $(".table").shouldHave(text("State and City Rajasthan Jaipur"));
    }
}
