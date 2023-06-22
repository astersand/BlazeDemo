package productTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;

public class CartTests extends BaseTests {
    @Test
    public void totalPriceTest() {
        ProductPage productPage = homePage.clickProductByName("Iphone 6 32gb");
        productPage.clickAddToCart();
        productPage.acceptAlert();
        CartPage cartPage = navigator.clickCartButton();
        Assert.assertEquals(cartPage.getTotalPrice(), "790", "The price is wrong");
    }
    @Test
    public void removeItemFromCartTest() throws InterruptedException {
        ProductPage productPage = homePage.clickProductByName("Iphone 6 32gb");
        productPage.clickAddToCart();
        productPage.acceptAlert();
        CartPage cartPage = navigator.clickCartButton();
        cartPage.deleteItemFromCart(0);
        Assert.assertEquals(cartPage.productCount(), 0, "Removing product didn't work");
    }

    @Test
    public void placeOrderTest() {
        ProductPage productPage = homePage.clickProductByName("Iphone 6 32gb");
        productPage.clickAddToCart();
        productPage.acceptAlert();
        CartPage cartPage = navigator.clickCartButton();
        cartPage.clickPlaceOrder();
        cartPage.setValueByName("Name", "Uros");
        cartPage.setValueByName("Country", "Serbia");
        cartPage.setValueByName("City", "Belgrade");
        cartPage.setValueByName("Card", "123456789");
        cartPage.setValueByName("Month", "10");
        cartPage.setValueByName("Year", "2024");
        cartPage.clickPurchaseButton();
        Assert.assertEquals(cartPage.getConfirmationMessage(), "Thank you for your purchase!", "wrong message");
    }
}
