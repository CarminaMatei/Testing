package Homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketPageTest {
    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/basket/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    public void verifyTotalAndSubtotal(){
        WebElement subtotalElement = driver.findElement(By.cssSelector(".cart-subtotal .woocommerce-Price-amount"));
        WebElement totalElement = driver.findElement(By.cssSelector(".order-total .woocommerce-Price-amount"));

        String subtotalText = subtotalElement.getText().replaceAll("[^\\d.]", "");
        String totalText = totalElement.getText().replaceAll("[^\\d.]", "");
        double subtotal = Double.parseDouble(subtotalText);
        double total = Double.parseDouble(totalText);

        assertTrue(total > subtotal, "Total value is not greater than subtotal value.");
    }

    @Test
    public void clickOnToProceedToChecout() throws InterruptedException {
        driver.findElement(By.cssSelector(".checkout-button")).click();
        Thread.sleep(2000);
        System.out.println("After click: " );
        System.out.println(driver.getCurrentUrl());
    }
}
