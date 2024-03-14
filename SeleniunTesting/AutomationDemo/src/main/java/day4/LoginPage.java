package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By usernameInput = By.id("username");

    By passwordInput = By.id("password");

    By submitButton = By.tagName("button");

    By flash = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
    }

    public SecurePage positiveLogin(){
        login(getUsername(), getPassword());
        return new SecurePage(driver);
    }
}
