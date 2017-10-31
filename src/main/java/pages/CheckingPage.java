package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckingPage extends BasePage {

    @FindBy(xpath = "//span[@id='amountOfCredit']")
    public WebElement creditAmount;

    @FindBy(xpath = "//span[@id='monthlyPayment']")
    public WebElement monthlyToll;

    @FindBy(xpath = "//span[@id='rate']")
    public WebElement yearlyPercent;

    public CheckingPage() {
        PageFactory.initElements(driver, this);
    }

    public String getValue(String fieldName) {
        switch (fieldName) {
            case "Сумма кредита":

                System.out.println(creditAmount.getText());
                return creditAmount.getText().replaceAll("\\D", "");
            case "Ежемесячный платеж":
                return monthlyToll.getText().replaceAll("\\D", "");
            case "Процентная ставка":
                return yearlyPercent.getText().replaceAll("\\D", "");// уберёт и ".", но пока пусть будет так
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

}
