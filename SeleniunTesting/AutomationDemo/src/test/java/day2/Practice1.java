package day2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

    @Test
    public void testSeleniun(){

        //selenium manager
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");

        //harcoded location
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //webdrivermanager banigarcia
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com/");
    }
}
