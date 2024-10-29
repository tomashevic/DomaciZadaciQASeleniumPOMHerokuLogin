package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HerokuappLoginPage {

    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;

    public HerokuappLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("radius"));
    }

    public void inputUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void inputPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
}
