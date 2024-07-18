package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponents {
    private SelenideElement resultsTable = $(".table");

    public ResultTableComponents checkResult(String key, String value) {
        resultsTable.shouldHave(text(key + " " + value));
        return this;
    }

    public void shouldNotBe(WebElementCondition visible) {
    }
}
