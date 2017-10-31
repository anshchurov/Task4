package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
        //menuSteps.closeChat();
    }

    @Then("^Выбрать 'приобретение готового жилья'$")
    public void chooseRF(){
        menuSteps.chooseReadyFlat();
    }


    @When("^Заполнить поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> fillingSteps.fillField(field, value));

    }

    @Then("^Значения полей:$")
    public void checkForm(DataTable fields){
        System.out.println("CHEKING!");
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> checkingSteps.checkField(field, value));
    }

    @Then("^Значения автозаполненных полей:$")
    public void checkAutoForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> checkingSteps.checkingAotuFields(field, value));
    }



}
