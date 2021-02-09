import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithFaker {
    Faker faker = new Faker();

    @Test
        void successfulFillFormTest() {
            String firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    email = faker.internet().emailAddress(),
                    gender = "Other",
                    mobile = faker.number().digits(10),
                    dayOfBirth = "14",
                    monthOfBirth = "April",
                    yearOfBirth = "1975",
                    subject1 = "Chemistry",
                    subject2 = "Commerce",
                    hobby1 = "Music",
                    hobby2 = "Reading",
                    hobby3 = "Sports",
                    currentAddress = "Goa India",
                    state = "Uttar Pradesh",
                    city = "Merrut";

        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(mobile);
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        File file = new File("src/test/resources/ejik.jpg");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        }
}
