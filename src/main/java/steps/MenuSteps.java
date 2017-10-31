package steps;

import pages.MenuPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MenuSteps {

    @Step("Зайти в меню «Взять кредит»")
    public void enterMenuTakeCredit(){
        new MenuPage().enterMenu();
    }

    @Step("выбрать «Приобретение готового жилья»")
    public void chooseReadyFlat(){
        new MenuPage().chooseCredit();
    }

    @Step("нажать рассчитать")
    public void pressCalc(){
        new MenuPage().pressCalc();
    }

    /*@Step("Закрыть чат")
    public void closeChat(){
        new MenuPage().closeChat();
    }*/
}
