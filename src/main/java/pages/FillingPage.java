package pages;

import org.openqa.selenium.By;
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

    public FillingPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Программа":
                /*if (driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).isEnabled()) {
                    System.out.println("Я слишком стар для этого дерьма");
                    driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).getAttribute("value");
                    driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).getAttribute("class");
                    driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).getAttribute("text()");
                    driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).getAttribute("text");
                    driver.findElement(By.xpath("//div[contains(@class, 'spinner-overlay')]")).getAttribute("id");
                    System.out.println("WTF");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                click(boxMenuOfProgram);
                if (value.equals("Купить готовую квартиру")) {
                    click(elementOfBoxMenuOfProgram);
                }
                sleep(2);
                break;
            case "Которая стоит":
                fillField(priceInput, value);
                break;
            case "У меня есть":
                fillField(moneyAmount, value);
                break;
            case "Кредит на срок":
                fillField(slavTime, value);
                break;
            case "Я получаю зарплату на карту Сбербанка":
                if (value.equals("1") &&
                        haveSberWorkCardCheck.getAttribute("class").equals("checkbox___3_Z2"))
                    click(haveSberWorkCardCheck);
            case "Скидка по федеральной программе 'Молодая семья'":
                if (value.equals("1") &&
                        yongFamilyCheck.getAttribute("class").equals("checkbox___3_Z2"))
                    click(yongFamilyCheck);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }


    public String getValue(String fieldName) {
        System.out.println("HERE&!&!&!&!");
        switch (fieldName) {
            case "Программа":
                return elementOfBoxMenuOfProgram.findElement(By.xpath("./span")).getText();
            case "Которая стоит":
                return priceInput.getAttribute("value").replaceAll("\\D", "");
            case "У меня есть":
                return moneyAmount.getAttribute("value").replaceAll("\\D", "");
            case "Кредит на срок":
                return slavTime.getAttribute("value").replaceAll("\\D", "");
            case "Я получаю зарплату на карту Сбербанка":
                if (haveSberWorkCardCheck.getAttribute("class").contains("checkboxOpened___3n1Y"))
                    return "1";
                else
                    return "0";
            case "Скидка по федеральной программе 'Молодая семья'":
                if (yongFamilyCheck.getAttribute("class").contains("checkboxOpened___3n1Y"))
                    return "1";
                else
                    return "0";
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

}
