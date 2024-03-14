package day3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice8 {

    @Test
    public void jsExecuterTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://the-internet.herokuapp.com/login");
        js.executeScript("document.getElementById('username').value='tomsmith';");
        js.executeScript("document.getElementById('password').value='SuperSecretPassword!';");

        WebElement button = driver.findElement(By.tagName("button"));
        js.executeScript("arguments[0].setAttribute('id','loginBtn')",button);
        js.executeScript("document.getElementById('loginBtn').click();");

        Thread.sleep(2000);
        js.executeScript("window.location = 'https://the-internet.herokuapp.com/large'");

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);

        js.executeScript("history.go(0);"); //refresh
        Thread.sleep(2000);

        driver.quit();
    }
}
