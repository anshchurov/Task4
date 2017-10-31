package steps;

import pages.CheckingPage;
import pages.FillingPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

public class CheckingSteps {

    @Step("Проверить поле {0] на значение {1}")
    public void checkField(String field, String value){
        System.out.println("CHECKING into!");
        String actual = new FillingPage().getValue(field).replaceAll("\\D", "");
        String rValue = value.replaceAll("\\D", "");
        assertEquals(String.format("Значение поля %s не равно %s. Получено значение %s",
                field, value, actual), rValue, actual);
    }

    @Step("Проверить поле {0} на автозаполнение значением {1}")
    public void checkingAotuFields(String field, String value){
        String actual = new CheckingPage().getValue(field);
        String rValue = value.replaceAll("\\D", "");
        assertEquals(String.format("Значение поля %s не равно %s. Получено значение %s",
                field, value, actual), rValue, actual);
    }

}
