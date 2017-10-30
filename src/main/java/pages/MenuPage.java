package pages;

import cucumber.api.java.da.Men;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {

    @FindBy(xpath = "(//span[@class='multiline']/span[text()='Взять '])[1]")
    public WebElement menuOpen;

    @FindBy(xpath = "(//a[text()='Приобретение готового жилья'])[1]")
    public WebElement chooseCreditType;

    @FindBy(xpath = "//a[@href='https://ipoteka.domclick.ru/#calc']")
    public WebElement calcBtn;

    @FindBy(xpath = "//div[@class='chat_button___2Qff chat_button_open___2rDC chat_button_alone___xNxC']")
    public WebElement closeChatBtn;

    public MenuPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterMenu() {
        click(menuOpen);
    }

    public void chooseCredit() {
        click(chooseCreditType);
    }

    public void pressCalc() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", calcBtn);
        click(calcBtn);
        driver.get(calcBtn.getAttribute("href"));
    }

    public void closeChat() {
        if (closeChatBtn.isDisplayed())
            click(closeChatBtn);
    }

}
