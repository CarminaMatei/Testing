package day2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

    @Test
    public void secondSeleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");

        Thread.sleep(2000);

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

       Dimension d1 = driver.manage().window().getSize();
        System.out.println("Dimension d1: " + d1);

        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Dimension d2 = new Dimension(300,200);
        driver.manage().window().setSize(d2);
        Thread.sleep(2000);

        driver.quit();

    }
}
