package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TestData {
    Faker faker = new Faker(Locale.ENGLISH);
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String phoneNumber = faker.number().digits(10);
    public String streetAddress = faker.address().streetAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public Date dateOfBirth = faker.date().birthday();
    public String hobbies = faker.options()
            .option("Sports", "Reading", "Music");
    public String picture = "1000.jpg";
    public String subjects = faker.options()
            .option("Maths", "Physics", "Chemistry", "Computer Science", "Economics", "Arts", "Social Studies", "History", "Civics");
    public String getState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String getCityForState(String state) {
        if ("NCR".equals(state)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options().option("Agra", "Lucknow", "Merrit");
        } else if ("Haryana".equals(state)) {
            return faker.options().option("Karnal", "Panipat");
        } else if ("Rajasthan".equals(state)) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return state;
    }

    ;

    public String getDay() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(dateOfBirth);
    }

    public String getMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return monthFormat.format(dateOfBirth);
    }

    public String getYear() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(dateOfBirth);
    }


}
