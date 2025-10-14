import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormDemoQaTest {
    @BeforeAll
    static void setupEnvironment(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successFillingFormTest(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Don");
        $("#lastName").setValue("Carlione");
        $("#userEmail").setValue("Carl@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9001112222");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value='3']").click();
        $(".react-datepicker__day.react-datepicker__day--005.react-datepicker__day--weekend").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Lesovskay 3");
        $("#state").$(byText("Select State")).click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").$(byText("Select City")).click();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Don Carlione"));
        $(".table-responsive").shouldHave(text("Carl@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9001112222"));
        $(".table-responsive").shouldHave(text("05 April,2025"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Lesovskay 3"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
