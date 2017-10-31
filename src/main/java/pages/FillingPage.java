package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillingPage extends BasePage {

    @FindBy(xpath = "//div[@id='productButton']/parent::div")
    public WebElement boxMenuOfProgram;

    @FindBy(xpath = "//div[@value='3']")
    public WebElement elementOfBoxMenuOfProgram;

    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement priceInput;

    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement moneyAmount;

    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement slavTime;

    @FindBy(xpath = "//input[@id='paidToCard']")
//span[text()='Я получаю зарплату на карту Сбербанка']/ancestor::div[@class='wrapper___1I6P switchRow___2-i_']/div/div[@class='checkbox___3_Z2 checkboxOpened___3n1Y']")
    public WebElement haveSberWorkCardCheck;

    @FindBy(xpath = "//input[@id='youngFamilyDiscount']")
    public WebElement yongFamilyCheck;

    @FindBy(xpath = "//div[@class='chat_button___2Qff chat_button_open___2rDC chat_button_alone___xNxC']")
    public WebElement closeChatBtn;

    public FillingPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Программа":
                System.out.println(fieldName);
                sleep(2);
                click(boxMenuOfProgram);
                if (value.equals("Купить готовую квартиру")) {
                    click(elementOfBoxMenuOfProgram);
                }
                sleep(2);
                break;
            case "Которая стоит":
                System.out.println(fieldName);
                fillPrice(priceInput, value);
                //fillField(priceInput, value);
                break;
            case "У меня есть":
                System.out.println(fieldName);
                fillPrice(moneyAmount, value);
                //fillField(moneyAmount, value);
                break;
            case "Кредит на срок":
                System.out.println(fieldName);
                fillField(slavTime, value);
                break;
            case "Я получаю зарплату на карту Сбербанка":
                System.out.println(fieldName);
                try {
                    if (closeChatBtn.isEnabled())
                        click(closeChatBtn);
                } catch (NoSuchElementException e) {
                }
                if (value.equals("1") &&
                        !haveSberWorkCardCheck.isSelected())
                    click(haveSberWorkCardCheck);
                break;
            case "Скидка по федеральной программе 'Молодая семья'":
                System.out.println(fieldName);
                try {
                    if (closeChatBtn.isEnabled())
                        click(closeChatBtn);
                } catch (NoSuchElementException e) {
                }
                scrollToElement(yongFamilyCheck.findElement(By.xpath("./parent::label")));
                System.out.println("scrolled");
                if (value.equals("1") &&
                        !yongFamilyCheck.isSelected()) {
                    System.out.println("!isSelected!");
                    click(yongFamilyCheck.findElement(By.xpath("./parent::label")));
                }
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }


    public String getValue(String fieldName) {
        System.out.println("in getValue");
        switch (fieldName) {
            case "Программа":
                scrollToElement(boxMenuOfProgram);
                System.out.println("scrolled");
                return boxMenuOfProgram.getText();
            case "Которая стоит":
                return priceInput.getAttribute("value").replaceAll("\\D", "");
            case "У меня есть":
                return moneyAmount.getAttribute("value").replaceAll("\\D", "");
            case "Кредит на срок":
                scrollToElement(slavTime);
                return slavTime.getAttribute("value").replaceAll("\\D", "");
            case "Я получаю зарплату на карту Сбербанка":
                if (haveSberWorkCardCheck.isSelected())
                    return "1";
                else
                    return "0";
            case "Скидка по федеральной программе 'Молодая семья'":
                scrollToElement(yongFamilyCheck.findElement(By.xpath("./parent::label")));
                System.out.println("scrolled for youngFamily");
                if (yongFamilyCheck.isSelected())
                    return "1";
                else
                    return "0";
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

}
