package Homework;

import day4.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePageTest {

    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }


    //3. Verify that the home page has three arrivals only in the 'new arrivals' section
    @Test
    public void haveNewArrivals(){
        WebElement newArrivalsSection = driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]"));

        List<WebElement> newArrivals = newArrivalsSection.findElements(By.cssSelector(".products .woocommerce-LoopProduct-link"));

        if (newArrivals.size() == 3) {
            System.out.println("Page has 3 new arrivals");
        } else {
            System.out.println("Page does not have 3 new arrivals");
        }
    }

//    4. Click on Shop Menu
    @Test
    public void clickOnShopMenu() throws InterruptedException {
        driver.findElement(By.linkText("Shop")).click();
        Thread.sleep(2000);
        System.out.println("After click: " );
        System.out.println(driver.getCurrentUrl());
    }

}
