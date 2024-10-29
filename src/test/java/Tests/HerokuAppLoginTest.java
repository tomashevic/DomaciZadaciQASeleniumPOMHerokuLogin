package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }


    @Test(priority = 10)
    public void userCanLogInWithValidCredentials() {

        String herokuAppLoginURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);

        String username = excelReader.getStringData("Sheet1", 1, 0);
        String password = excelReader.getStringData("Sheet1", 1, 1);

        herokuappLoginPage.inputUsername(username);
        herokuappLoginPage.inputPassword(password);
        herokuappLoginPage.clickOnLoginButton();

        String loggedInURL = "https://the-internet.herokuapp.com/secure";
        Assert.assertNotEquals(driver.getCurrentUrl(), herokuAppLoginURL);
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        Assert.assertTrue(securePage.getLogOutButton().isDisplayed());
        System.out.println(securePage.getMessage().getText());
    }

    @Test(priority = 20)
    public void userCannotlogInWithInvalidUsername() {

        String herokuAppLoginURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);

        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {

            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String password = excelReader.getStringData("Sheet1", 1, 1);

            herokuappLoginPage.inputUsername(invalidUsername);
            herokuappLoginPage.inputPassword(password);
            herokuappLoginPage.clickOnLoginButton();

            String loggedInURL = "https://the-internet.herokuapp.com/secure";
            Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);
            Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);
            Assert.assertTrue(herokuappLoginPage.getLoginButton().isDisplayed());
            System.out.println(securePage.getMessage().getText());

        }
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() {

        String herokuAppLoginURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);

        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {

            String username = excelReader.getStringData("Sheet1", 1, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);

            herokuappLoginPage.inputUsername(username);
            herokuappLoginPage.inputPassword(invalidPassword);
            herokuappLoginPage.clickOnLoginButton();

            String loggedInURL = "https://the-internet.herokuapp.com/secure";
            Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);
            Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);
            Assert.assertTrue(herokuappLoginPage.getLoginButton().isDisplayed());
            System.out.println(securePage.getMessage().getText());
        }
    }

    @Test(priority = 40)
    public void userCannotLogInWithInvalidUsernameAndInvalidPassword() {

        String herokuAppLoginURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);

        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {

            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);

            herokuappLoginPage.inputUsername(invalidUsername);
            herokuappLoginPage.inputPassword(invalidPassword);
            herokuappLoginPage.clickOnLoginButton();

            String loggedInURL = "https://the-internet.herokuapp.com/secure";
            Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);
            Assert.assertEquals(driver.getCurrentUrl(), herokuAppLoginURL);
            Assert.assertTrue(herokuappLoginPage.getLoginButton().isDisplayed());
            System.out.println(securePage.getMessage().getText());
        }
    }
}
