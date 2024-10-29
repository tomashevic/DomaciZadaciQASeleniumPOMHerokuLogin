package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurePage {

    WebDriver driver;
    WebElement logOutButton;
    WebElement message;

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("flash"));
    }

    public void clicOnLogOutButton() {
        getLogOutButton().click();
    }
}
