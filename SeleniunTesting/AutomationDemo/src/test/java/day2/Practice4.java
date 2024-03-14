package day2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Practice4 {

    WebDriver driver;

    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    public void selectTest() throws InterruptedException {
        WebElement dropDown1 = driver.findElement(By.id("dropdowm-menu-1"));
        Select sel1 = new Select(dropDown1);
        sel1.selectByIndex(2);
        Thread.sleep(2000);

        WebElement dropDown2 = driver.findElement(By.id("dropdowm-menu-2"));
        Select sel2 = new Select(dropDown2);
        sel2.selectByValue("junit");
        Thread.sleep(2000);

        WebElement dropDown3 = driver.findElement(By.id("dropdowm-menu-3"));
        Select sel3 = new Select(dropDown3);
        sel3.selectByVisibleText("CSS");
        Thread.sleep(2000);

        List<WebElement> options3 = sel3.getOptions();
        for (WebElement o : options3){
            System.out.println(o.getAttribute("value" + " "));
        }
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        WebElement option2 = driver.findElement(By.xpath("//input[@value='option-2']"));
        option2.click();

        WebElement option3 = driver.findElement(By.xpath("//input[@value='option-3']"));
        option3.click();

        Thread.sleep(2000);

        assertTrue(option2.isSelected());
        assertFalse(option3.isSelected());
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(By.name("color"));

        System.out.println("Radio buttons: "+ radioButtons.size());

        for (WebElement radio: radioButtons
             ) {
            if(radio.getAttribute("value").equals("orange")){
                radio.click();
            }

        }

        Thread.sleep(2000);

        WebElement orange = driver.findElement(By.xpath("//input[@value='orange']"));
        assertTrue(orange.isSelected());
    }
}
