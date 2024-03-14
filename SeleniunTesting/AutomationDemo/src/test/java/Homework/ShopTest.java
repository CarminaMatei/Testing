package Homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ShopTest {

    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/shop/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }

//    5. Change 'Default sorting' to 'Sort by average rating'
    @Test
    public void sortByAvarageRating() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.className("orderby"));
        Select select = new Select(dropDown);
        select.selectByValue("rating");
        System.out.println("Change 'Default sorting' to 'Sort by average rating' is ok");
        Thread.sleep(2000);
    }

//    6. Click on 'Mastering JavaScript'
    @Test
    public void clickOnMasteringJavaScript() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]")).click();
        Thread.sleep(2000);
        System.out.println("After click: " );
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
    }

}
