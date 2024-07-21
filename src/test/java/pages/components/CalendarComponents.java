package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");
    private SelenideElement daySelect(String day) {
        return $(".react-datepicker__month").$(byText(day));
    }
    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect(day).click();
    }
}
