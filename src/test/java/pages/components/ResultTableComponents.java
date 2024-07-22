package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponents {
    private final SelenideElement resultsTable = $(".table");

    public ResultTableComponents checkResult(String key, String value) {
        resultsTable.shouldHave(text(key + " " + value));
        return this;
    }

    public void checkResultsTableNotVisible() {
        resultsTable.shouldNotBe(visible);
    }
}
