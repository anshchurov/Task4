package steps;

import pages.FillingPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FillingSteps {

    @Step("заполнить поле {0} значением {1}")
    public void fillField(String field, String value){
        FillingPage fillingPage = new FillingPage();
        fillingPage.fillField(field, value);
    }

}
