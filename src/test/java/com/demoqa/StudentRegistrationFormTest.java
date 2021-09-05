package com.demoqa;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;

public class StudentRegistrationFormTest {

    private String firstName = "Irina";
    private String lastName = "Guskova";
    private String userEmail = "irina.guskova.2704@gmail.com";
    private String gender = "Female";
    private String number = "8968193581";
    private String month = "April";
    private String year = "1993";
    private String subject = "English";
    private String hobby = "Sports";
    private String address = "Parashutnaya street, 33k1";
    private String state = "Haryana";
    private String city = "Panipat";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Tuesday, April 27th, 1993']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("img/ava1.jpeg");
        $("#currentAddress").setValue(address);
        $("#submit").scrollIntoView(true);
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Irina Guskova"));
        $(".table-responsive").shouldHave(text("irina.guskova.2704@gmail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8968193581"));
        $(".table-responsive").shouldHave(text("27 April,1993"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("ava1.jpeg"));
        $(".table-responsive").shouldHave(text("Parashutnaya street"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));
    }


}
