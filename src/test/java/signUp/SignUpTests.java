package signUp;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTests {
    @Test
    public void successfulSignUpTest() {
        navigator.clickSignInButton();
        homePage.setSignUpUsername("Test588");
        homePage.setSignUpPassword("123456");
        homePage.clickSignUpButton();
        Assert.assertEquals(homePage.getAlertText(), "Sign up successful.", "Sign up was not successful");
        homePage.acceptAlert();
    }
    @Test
    public void signUpWithExistingUserTest() {
        navigator.clickSignInButton();
        homePage.setSignUpUsername("Test586");
        homePage.setSignUpPassword("123456");
        homePage.clickSignUpButton();
        Assert.assertEquals(homePage.getAlertText(), "This user already exist.", "User is signed up");
        homePage.acceptAlert();
    }
}
