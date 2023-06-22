package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void invalidPasswordTest() {
        navigator.clickLoginButton();
        homePage.setLoginUsername("Test586");
        homePage.setLoginPassword("654789");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getAlertText(), "Wrong password.", "User logged in");
        homePage.acceptAlert();
        homePage.clickCloseButton();
    }
    @Test
    public void invalidUserNameTest() {
        navigator.clickLoginButton();
        homePage.setLoginUsername("fagfasfsadasf");
        homePage.setLoginPassword("123456");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getAlertText(), "User does not exist.");
        homePage.acceptAlert();
        homePage.clickCloseButton();
    }
    @Test
    public void successfulLoginTest(){
        navigator.clickLoginButton();
        homePage.setLoginUsername("Test586");
        homePage.setLoginPassword("123456");
        homePage.clickLoginButton();
        Assert.assertEquals(navigator.getLoggedInUsername(), "Welcome Test586");
    }
}
