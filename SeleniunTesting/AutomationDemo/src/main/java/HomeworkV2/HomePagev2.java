package HomeworkV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePagev2 extends FirstPage{
    WebElement newArrivalsSection = driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]"));
    List<WebElement> newArrivals = newArrivalsSection.findElements(By.cssSelector(".products .woocommerce-LoopProduct-link"));

    By shopBtn = By.linkText("Shop");


    public HomePagev2(WebDriver driver) {
        super(driver);
    }

    public boolean haveNewArrivals(){
        if (newArrivals.size() == 3) {
            System.out.println("Page has 3 new arrivals");
        } else {
            System.out.println("Page does not have 3 new arrivals");
        }
        return false;
    }

    public ShopPagev2 clickShopBtn(){
        click(shopBtn);
        return new ShopPagev2(driver);
    }


}
