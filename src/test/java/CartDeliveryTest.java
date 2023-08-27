import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Selenide.*;

public class CartDeliveryTest {
    private String generateDate(int addDays, String pattern){
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldBeSuccesfull(){
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Казань");
        String currentDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input").
        $("[data-test-id='date'] input").
        $("[data-test-id='name'] input").setValue("Калыкин-Калык-Максимович");
        $("[data-test-id='phone'] input").setValue("+78005556767");
        $("[data-test-id='agreement'] input").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + currentDate));
    }
}
