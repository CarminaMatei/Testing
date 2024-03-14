package HomeworkV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FirstPage {
    protected static WebDriver driver;

    static FileReader fileReader;

    static Properties properties = new Properties();

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getPropertyValue(String key){

        try {
            fileReader = new FileReader("src/main/resources/app.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return properties.getProperty(key);
    }

    public static void loadBaseUrl(){
        String url = getPropertyValue("url");
        driver.get(url);
    }

    public void click(By element){find(element).click();
    }

    public WebElement find(By element){
        return driver.findElement(element);
    }

    public static String getFirstName(){
        return getPropertyValue("firstName");
    }

    public static String getLastName(){
        return getPropertyValue("LastName");
    }

    public static String getEmail(){
        return getPropertyValue("Email");
    }

    public static String getPhoneNumber(){
        return getPropertyValue("Phone");
    }

    public static String getAdress(){
        return getPropertyValue("Adress");
    }

    public static String getTown(){
        return getPropertyValue("Town");
    }

    public static String getPostcode(){
        return getPropertyValue("Postcode");
    }
    public void type(By element, String text){
        find(element).sendKeys(text);
    }

    public boolean isDisplayed(ShopPagev2 element){
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        return true;
    }

}
