package Base;

import Pages.HerokuappLoginPage;
import Pages.SecurePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public HerokuappLoginPage herokuappLoginPage;
    public ExcelReader excelReader;
    public SecurePage securePage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        excelReader = new ExcelReader("Heroku.xlsx");

        herokuappLoginPage = new HerokuappLoginPage(driver);
        securePage = new SecurePage(driver);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
