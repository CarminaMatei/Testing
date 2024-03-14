package HomeworkV2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static day4.BasePage.getPropertyValue;

public class FirstPageTest {
    protected WebDriver driver;

    protected FirstPage firstPage;

    protected HomePagev2 homePage;

    protected ShopPagev2 shopPage;

    protected MasteringJavaScriptv2 masteringJavaScript;

    protected BasketPageTestv2 basketPage;

    protected OrderPagetestv2 orderPage;

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
        firstPage = new FirstPage(driver);
        homePage = new HomePagev2(driver);
        shopPage = new ShopPagev2(driver);
        masteringJavaScript = new MasteringJavaScriptv2(driver);
        basketPage = new BasketPageTestv2(driver);
        orderPage = new OrderPagetestv2(driver);
        FirstPage.loadBaseUrl();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void after(){
        driver.quit();
    }
}
