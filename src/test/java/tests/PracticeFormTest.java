package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void Form() {

    open("https://demoqa.com/automation-practice-form");

    $("#firstName").setValue("Dim");
    $("#lastName").setValue("Dyn");
    $("#userEmail").setValue("dima@gmail.com");
    $("#userNumber").setValue("79999999999");
    $("#genterWrapper").$(byText("Male")).click();

    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("1995");
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("January");
    $(".react-datepicker__day--0" + 25).click();
    $("#subjectsInput").val("Arts");
    $(".subjects-auto-complete__menu").$(byText("Arts")).click();
    $("#subjectsInput").val("Accounting");
    $(".subjects-auto-complete__menu").$(byText("Accounting")).click();
    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#hobbiesWrapper").$(byText("Reading")).click();
    $("#hobbiesWrapper").$(byText("Music")).click();
    $("#uploadPicture").uploadFromClasspath("image.png");
    $("#currentAddress").setValue("adaa daa dada");

    $("#state").click();
    $("#state").$(byText("Haryana")).click();
    $("#city").click();
    $("#city").$(byText("Karnal")).click();
    $("#submit").click();

    $(".table-responsive").shouldHave(text("Label Values\n" + "Student Name Dim Dyn\n"));
    $(".table-responsive").shouldHave(text("Student Email dima@gmail.com"));
    $(".table-responsive").shouldHave(text("Gender Male"));
    $(".table-responsive").shouldHave(text("Mobile 7999999999"));
    $(".table-responsive").shouldHave(text("Date of Birth 25 January,1995"));
    $(".table-responsive").shouldHave(text("Subjects Arts, Accounting"));
    $(".table-responsive").shouldHave(text("Hobbies Sports, Reading, Music"));
    $(".table-responsive").shouldHave(text("Picture image.png"));
    $(".table-responsive").shouldHave(text("Address adaa daa dada"));
    $(".table-responsive").shouldHave(text("State and City Haryana Karnal"));
    }
}
