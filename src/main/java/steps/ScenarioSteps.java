package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FillingPage;

public class ScenarioSteps {

    MenuSteps menuSteps = new MenuSteps();
    FillingSteps fillingSteps = new FillingSteps();
    CheckingSteps checkingSteps = new CheckingSteps();

    @When("^Открыть меню 'Взять кредит'$")
    public void openMenu(){
        menuSteps.enterMenuTakeCredit();
    }

    @Then("^Нажать кнопку рассчитать$")
    public void presscalc(){
        menuSteps.pressCalc();
    }

    @Then("^Выбрать 'приобретение готового жилья'$")
    public void chooseRF(){
        menuSteps.chooseReadyFlat();
    }


    @When("^Заполнить поля:$")
    public void fillForm(DataTable fields){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> fillingSteps.fillField(field, value));
        new FillingPage().isChat();

    }

    @Then("^Значения полей:$")
    public void checkForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> checkingSteps.checkField(field, value));
    }

    @Then("^Значения автозаполненных полей:$")
    public void checkAutoForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> checkingSteps.checkingAotuFields(field, value));
    }



}
