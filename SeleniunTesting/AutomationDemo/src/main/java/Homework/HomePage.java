package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HomePage {
    protected WebDriver driver;

    static FileReader fileReader;

    static Properties properties = new Properties();

    protected WebDriver wait;

    int timeoutSec = 5;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = (WebDriver) new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
//        this.wait = new WebDriverWait(driver, timeoutSec);
    }

    public static String getPropertyValue(String key){

        try {
            fileReader = new FileReader("src/main/resources/appHomework.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return properties.getProperty(key);
    }

    public void loadBaseUrl(){
        String url = getPropertyValue("url");
        driver.get(url);
    }

    public static String getBrowser(){
        return getPropertyValue("browser");
    }

    public void click(By element){
        find(element).click();
    }

    public WebElement find(By element){
        return driver.findElement(element);
    }

    public void type(By element, String text){
        find(element).sendKeys(text);
    }

//    public WebElement find(By element){
//        return driver.findElement(element);
//    }

    public String getText(By element){
        return find(element).getText();
    }
}
