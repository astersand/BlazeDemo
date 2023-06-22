package base;

import common.Navigator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected Navigator navigator;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        this.homePageInit();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void homePageInit() {
        driver.get("https://demoblaze.com/");
        homePage = new HomePage(driver);
        navigator = new Navigator(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
