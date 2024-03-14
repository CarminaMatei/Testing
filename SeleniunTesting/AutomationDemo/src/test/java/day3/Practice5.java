package day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice5 {
    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){driver.quit();}

    @Test
    public void iFrameTest() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");


        Thread.sleep(2000);
        WebElement textArea = driver.findElement(By.id("tinymce"));
        textArea.clear();
        Thread.sleep(2000);
        textArea.sendKeys("New text");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
    }

    @Test
    public void alertTest() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement confirmAlert = driver.findElements(By.tagName("button")).get(1);
        confirmAlert.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: "+ alert.getText());
        assertEquals("I am a JS Confirm", alert.getText());

        alert.dismiss();
        Thread.sleep(2000);

        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
        assertEquals("You clicked: Cancel", result.getText());


        }

    @Test
    public void switchToWindow() throws InterruptedException{
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);
        driver.navigate().to("https://www.selenium.dev/");

    }

    @Test
    public void switchToTab() throws InterruptedException{
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.navigate().to("https://www.selenium.dev/");
    }

    @Test
    public void windowsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String firstWindow = driver.getWindowHandle();

        System.out.println("First window handle: " + firstWindow);

        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);

        System.out.println("After click: " );
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());

        Set<String> allWindows = driver.getWindowHandles();

        for (String window: allWindows){
            if(!window.equals(firstWindow)){
                driver.switchTo().window(window);
            }
        }

        System.out.println("After switch: ");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());

        assertEquals("http://the-internet.herokuapp.com/windows/new",driver.getCurrentUrl());
        assertEquals("New Window", driver.getTitle());
    }

}
