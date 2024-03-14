package HomeworkV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPagetestv2 extends FirstPage {

    WebElement firstNameField = driver.findElement(By.id("billing_first_name"));
    WebElement lastNameField = driver.findElement(By.id("billing_last_name"));
    WebElement emailField = driver.findElement(By.id("billing_email"));
    WebElement phoneField = driver.findElement(By.id("billing_phone"));
    WebElement dropDownCountry = driver.findElement(By.id("select2-drop"));
    WebElement addressField = driver.findElement(By.id("billing_address_1"));
    WebElement cityField = driver.findElement(By.id("billing_city"));
    WebElement postcodeField = driver.findElement(By.id("billing_postcode"));
    List<WebElement> radioButtons = driver.findElements(By.name("payment_method"));
    public OrderPagetestv2(WebDriver driver) {super(driver);
    }

    public void fillFildes(String firstName, String lastName, String email, String phone,
                           String adress, String citty, String postcode){
        type((By) firstNameField, firstName);
        type((By) lastNameField, lastName);
        type((By) emailField, email);
        type((By) phoneField, phone);
        type((By) addressField,adress);
        type((By) cityField,citty);
        type((By) postcodeField,postcode);
        Select select = new Select(dropDownCountry);
    }

    public void selectMethotPayment(){
        for (WebElement radio : radioButtons
        ) {
            if (radio.getAttribute("value").equals("Cash on Delivery")) {
                radio.click();
            }
    }
    }


}
