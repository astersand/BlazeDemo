package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By loginUsername = By.id("loginusername");
    private By loginPassword = By.id("loginpassword");
    private By signUpUsername = By.id("sign-username");
    private By signUpPassword = By.id("sign-password");
    private By closeButton = By.cssSelector("#logInModal .btn.btn-secondary");
    private By loginButton = By.xpath(".//button[text()='Log in']");
    private By signupButton = By.xpath(".//button[text()='Sign up']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductPage clickProductByName(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(productName)));
        driver.findElement(By.linkText(productName)).click();
        return new ProductPage(driver);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    public void clickSignUpButton() {
        driver.findElement(signupButton).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void setLoginUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUsername));
        driver.findElement(loginUsername).sendKeys(username);
    }
    public void setLoginPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void setSignUpUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpUsername));
        driver.findElement(signUpUsername).sendKeys(username);
    }
    public void setSignUpPassword(String password) {
        driver.findElement(signUpPassword).sendKeys(password);
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
}
