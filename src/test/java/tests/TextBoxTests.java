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
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Name");
        $("[id=lastName]").setValue("Last");
        $("[id=userEmail]").setValue("Name@gmail.com");
        $("[id=userNumber]").setValue("1234567890");
        $("label[for='gender-radio-2']").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1970");
        $(".react-datepicker__day--001").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("1000.jpg");
        $("[id=currentAddress]").setValue("SPb");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Math");
        $$(".subjects-auto-complete__option").findBy(text("Maths")).should(appear).click();
        $("#state").click();
        $("#react-select-3-option-3").click();
        //$$(".css-11unzgr .css-1n7v3ny-option, .css-yt9ioa-option").findBy(text("NCR")).click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        //$$(".css-11unzgr .css-1n7v3ny-option, .css-yt9ioa-option").findBy(text("Delhi")).click();
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
