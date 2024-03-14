package Homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrderPageTest {

    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/checkout/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    public void fillFildes() throws InterruptedException {
        WebElement firstNameField = driver.findElement(By.id("billing_first_name"));
        firstNameField.sendKeys("Carmina");
        Thread.sleep(2000);

        WebElement lastNameField = driver.findElement(By.id("billing_last_name"));
        lastNameField.sendKeys("Matei");
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.id("billing_email"));
        emailField.sendKeys("carmina.matei.99@gmail.com");
        Thread.sleep(2000);

        WebElement phoneField = driver.findElement(By.id("billing_phone"));
        phoneField.sendKeys("0764613323");
        Thread.sleep(2000);

//            WebElement dropDownCountry = driver.findElement(By.id("select2-drop"));
//            Select select = new Select(dropDownCountry);
//            select.selectByValue("Romania");
//            Thread.sleep(2000);

        WebElement addressField = driver.findElement(By.id("billing_address_1"));
        addressField.sendKeys("my address");
        Thread.sleep(2000);

        WebElement cityField = driver.findElement(By.id("billing_city"));
        cityField.sendKeys("Craiova");
        Thread.sleep(2000);

        WebElement postcodeField = driver.findElement(By.id("billing_postcode"));
        postcodeField.sendKeys("201302");
        Thread.sleep(2000);

        List<WebElement> radioButtons = driver.findElements(By.name("payment_method"));
        for (WebElement radio : radioButtons
        ) {
            if (radio.getAttribute("value").equals("Cash on Delivery")) {
                radio.click();
            }
        }
    }
}
