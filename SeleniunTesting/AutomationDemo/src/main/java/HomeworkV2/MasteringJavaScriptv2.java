package HomeworkV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static HomeworkV2.FirstPage.driver;

public class MasteringJavaScriptv2 extends FirstPage {
    
    WebDriver addToBasketBtn = (WebDriver) driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt"));
    WebDriver basketBtn = (WebDriver) driver.findElement(By.cssSelector(".wpmenucart-contents"));
    public MasteringJavaScriptv2(WebDriver driver) {
        super(driver);
    }

    public void clickOnMasteringJavaScript(){
        click((By) addToBasketBtn);
    }

    public  BasketPageTestv2 clickOnBasketBtn(){
        click((By) basketBtn);
        return new BasketPageTestv2(driver);
    }

}
