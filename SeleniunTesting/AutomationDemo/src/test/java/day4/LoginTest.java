package day4;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void testLoginFailureUsername(){
        loginPage.login("username", BasePage.getPassword());
        assertTrue(loginPage.getText(loginPage.flash).contains("Your username is invalid!"));
    }

    @Test
    public void testLoginFailurePassword(){
        loginPage.login(BasePage.getUsername(),"parola");
        assertTrue(loginPage.getText(loginPage.flash).contains("Your password is invalid!"));

    }

    @Test
    public void testLoginSuccess(){
        securePage = loginPage.positiveLogin();
        assertTrue(basePage.isDisplayed(securePage.flash));
        assertTrue(securePage.getText(securePage.flash).contains("You logged into a secure area!"));
    }

}
