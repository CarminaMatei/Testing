package day2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Practice3 {

    WebDriver driver;

    @BeforeEach
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginFailWrongUsername(){
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();

//        assertEquals("http://the-internet.herokuapp.com/login",driver.getCurrentUrl());
        assertEquals("http://the-internet.herokuapp.com/secure",driver.getCurrentUrl());

        WebElement element = driver.findElement(By.id("flash"));
        assertTrue(element.isDisplayed());
        assertTrue(element.getText().contains("Your username is invalid"));


    }

    @Test
    public void loginFailWrongPassword(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.tagName("button")).click();

        assertEquals("http://the-internet.herokuapp.com/login",driver.getCurrentUrl());
//        assertEquals("http://the-internet.herokuapp.com/secure",driver.getCurrentUrl());

        WebElement element = driver.findElement(By.id("flash"));
        assertTrue(element.isDisplayed());
        assertTrue(element.getText().contains("Your password is invalid"));
    }

    @Test
    public void loginSucces(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();

//        assertEquals("http://the-internet.herokuapp.com/login",driver.getCurrentUrl());
        assertEquals("http://the-internet.herokuapp.com/secure",driver.getCurrentUrl());

        WebElement element = driver.findElement(By.id("flash"));
        assertTrue(element.isDisplayed());
        assertTrue(element.getText().contains("You logged into a secure area!"));
        assertTrue(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());
    }
}
