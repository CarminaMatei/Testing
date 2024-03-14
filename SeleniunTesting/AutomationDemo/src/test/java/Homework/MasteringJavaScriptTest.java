package Homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasteringJavaScriptTest {
    WebDriver driver;

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/product/mastering-javascript/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void clickOnMasteringJavaScript() throws InterruptedException {
//        7. Click on the ADD TO BASKET button
        driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt")).click();
        Thread.sleep(2000);
        System.out.println("After click: ");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

//        8. Check whether the VIEW BASKET button is visible and click on it
        driver.findElement(By.cssSelector(".wpmenucart-contents")).click();
        Thread.sleep(2000);
        System.out.println("After click: ");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        //Am continuat in aceasta clasa pentru ca desi am pus link-ul in celelalte 2 dadea eroare la gasirea paginii web

        //        9. Now user can find total and subtotal values just above the Proceed to Checkout button,
//        verify that the total is greater than the subtotal
        WebElement subtotalElement = driver.findElement(By.cssSelector(".cart-subtotal .woocommerce-Price-amount"));
        WebElement totalElement = driver.findElement(By.cssSelector(".order-total .woocommerce-Price-amount"));


        String subtotalText = subtotalElement.getText().replaceAll("[^\\d.]", "");
        String totalText = totalElement.getText().replaceAll("[^\\d.]", "");
        double subtotal = Double.parseDouble(subtotalText);
        double total = Double.parseDouble(totalText);

        assertTrue(total > subtotal, "Total value is not greater than subtotal value.");

//        10. Click the PROCEED TO CHECKOUT button
        driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
        Thread.sleep(2000);
        System.out.println("After click: ");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

//        11. Fill in all required fields, set Cash on Delivery as your payment method, and click PLACE ORDER
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

            //Am comentat aceeste linii pentru ca probabil nu am identificat bine elementul
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


//        12. Check if the Payment method is set to Cash on Delivery in both 'PAYMENT METHOD' fields in the 'Order Details' page
        List<WebElement> radioButtons = driver.findElements(By.name("payment_method"));
        for (WebElement radio : radioButtons
        ) {
            if (radio.getAttribute("value").equals("Cash on Delivery")) {
                radio.click();
            }
        }

    }
}
