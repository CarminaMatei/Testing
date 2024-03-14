package day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static day4.BasePage.getPropertyValue;

public class BaseTest {

    protected WebDriver driver;

    protected BasePage basePage;

    protected LoginPage loginPage;

    protected SecurePage securePage;

    public WebDriver getDriver(){
        String browser = getPropertyValue("browser");

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    @BeforeEach
    public void setup(){
        driver = getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);
        basePage.loadBaseUrl();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }
}
