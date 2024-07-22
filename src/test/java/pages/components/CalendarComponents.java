package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");

    private SelenideElement getDayElement(String day) {
        String daySelector = String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", day);
        return $(daySelector);
    }

    private String formatDay(String day) {
        return String.format("%03d", Integer.parseInt(day));
    }

    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        getDayElement(formatDay(day)).click();
    }
}
