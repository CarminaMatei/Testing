package HomeworkV2;

import day4.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPageTestv2 extends FirstPage {

    WebElement subtotalElement = driver.findElement(By.cssSelector(".cart-subtotal .woocommerce-Price-amount"));
    WebElement totalElement = driver.findElement(By.cssSelector(".order-total .woocommerce-Price-amount"));
    WebElement checkoutBtn = driver.findElement(By.cssSelector(".checkout-button"));

    public void verifyTotalAndSubtotal(){
        String subtotalText = subtotalElement.getText().replaceAll("[^\\d.]", "");
        String totalText = totalElement.getText().replaceAll("[^\\d.]", "");
        double subtotal = Double.parseDouble(subtotalText);
        double total = Double.parseDouble(totalText);

//        assertTrue(total > subtotal, "Total value is not greater than subtotal value.");
    }

    public OrderPagetestv2 clickOnToProceedToCheckout(){
        click((By) checkoutBtn);
        return new OrderPagetestv2(driver);
    }

    public BasketPageTestv2(WebDriver driver) {
        super(driver);
    }
}
