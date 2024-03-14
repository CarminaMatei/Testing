package day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class Practice6 {

    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/broken_images");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    public void screenshotTest() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("src/main/resources/ScreenShot.jpg"));
    }

    @Test
    public void testWebElementScreenshot() throws IOException {
        WebElement content = driver.findElement(By.id("content"));

        File screenshot = content.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("src/main/resources/elementScreenshot.png"));

    }
}
