package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.HomePage;

import java.time.Duration;

public class Navigator {
    private WebDriver driver;
    private By homeLink = By.partialLinkText("Home");
    private By cartLink = By.linkText("Cart");
    private By loginLink = By.id("login2");
    private By signinLink = By.id("signin2");
    private By loggedInUser = By.id("nameofuser");
    public Navigator(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage returnToHomePage() {
        driver.findElement(homeLink).click();
        return new HomePage(driver);
    }
    public CartPage clickCartButton() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
    public void clickLoginButton() {
        driver.findElement(loginLink).click();
    }
    public void clickSignInButton() {
        driver.findElement(signinLink).click();
    }
    public String getLoggedInUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
        return driver.findElement(loggedInUser).getText();
    }
}
