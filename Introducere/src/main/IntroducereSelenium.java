package main;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroducereSelenium {

    public static void main(String[] args) {
        //Invoking Browser
        //chromedriver.exe - > Chrome browser
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\carmi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://myelectrica.ro/");
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.name("email")).sendKeys("mail@yahoo.com");
        driver.findElement(By.id(":r1:")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div[1]/div/form/div[2]/button")).click();

        driver.close();
    }
}
