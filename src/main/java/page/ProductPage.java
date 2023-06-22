package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.linkText("Add to cart");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCart() {
        waitForProductPageToLoad();
        driver.findElement(addToCartButton).click();
    }
    private void waitForProductPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
    }

    public String getAlertText() {
        waitForAlertToBecomeVisible();
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        waitForAlertToBecomeVisible();
        driver.switchTo().alert().accept();
    }
    private void waitForAlertToBecomeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
