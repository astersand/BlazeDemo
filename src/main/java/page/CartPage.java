package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By placeOrderButton = By.cssSelector(".btn.btn-success");
    private By closeButton = By.cssSelector("#orderModal .btn.btn-secondary");
    private By purchaseButton = By.cssSelector("#orderModal .btn.btn-primary");
    private By allRowsSelector = By.cssSelector("tbody tr");
    private By totalPrice = By.id("totalp");
    private By confirmationMessage = By.cssSelector(".sweet-alert h2");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void setValueByName(String fieldName, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        driver.findElement(By.id(fieldName.toLowerCase())).sendKeys(value);
    }
    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }
    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    public int productCount() throws InterruptedException {
        Thread.sleep(500);
        var allRows = rowsCollection();
        return allRows.size();
    }
    public String getTotalPrice() {
        this.waitForTotalPriceToLoad();
        return driver.findElement(totalPrice).getText();
    }
    public void deleteItemFromCart(int itemIndex) {
        this.waitForTotalPriceToLoad();
        var allRows = rowsCollection();
        allRows.get(itemIndex).findElement(By.linkText("Delete")).click();
    }
    private void waitForTotalPriceToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
    }
    private void waitForProductTableToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("tbody tr")));
    }
    private List<WebElement> rowsCollection() {
        return driver.findElements(allRowsSelector);
    }
    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
