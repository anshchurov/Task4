package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();
    private Actions action;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void fillField(WebElement element, String value) {
        click(element);
        element.clear();
        element.sendKeys(Keys.HOME);
        String N = value.charAt(0) + "";
        element.sendKeys(N);
        element.sendKeys(Keys.RIGHT);
        element.sendKeys(Keys.BACK_SPACE);
        N = value.charAt(1) + "";
        element.sendKeys(N);
    }

    public void fillPrice(WebElement element, String value){
        click(element);
        element.clear();
        element.sendKeys(Keys.HOME);
        String N = value.charAt(0) + "";
        element.sendKeys(N);
        element.sendKeys(Keys.RIGHT);
        element.sendKeys(Keys.RIGHT);
        element.sendKeys(Keys.BACK_SPACE);
    }




    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
        sleep(1);
        element.click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
        sleep(1);
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
