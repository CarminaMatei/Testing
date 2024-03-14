package day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice7 {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void before(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
    }

    @AfterEach
    public void after(){driver.quit();}

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions/index.html");

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(from, to).perform();
        Thread.sleep(2000);

        assertEquals("Dropped!",to.getText());
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));

        actions.contextClick(element).perform();
        Thread.sleep(2000);
        assertEquals("You selected a context menu",driver.switchTo().alert().getText());
    }

    @Test
    public void keyboardInteractions() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement target = driver.findElement(By.id("target"));
        actions.keyDown(Keys.SHIFT).sendKeys(target,"endava").keyUp(Keys.SHIFT).sendKeys("endava").perform();
        Thread.sleep(2000);
    }

    @Test
    public void multipleSelect() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        Select select = new Select(driver.findElement(By.name("selenium_commands")));
        select.deselectAll();
        Thread.sleep(2000);
        List<WebElement> options = select.getOptions();

        actions.keyDown(Keys.CONTROL)
                .click(options.get(1))
                .click(options.get(2))
                .perform();

        Thread.sleep(2000);
    }
}
