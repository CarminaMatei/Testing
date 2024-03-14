package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{

    By flash = By.id("flash");

    By logoutButton = By.linkText("Logout");

    public SecurePage(WebDriver driver){
        super(driver);
    }

}
