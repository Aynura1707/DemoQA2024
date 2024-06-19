package com.demoqa.wildberries;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class WildberriesTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ainur\\IdeaProjects\\HTML\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    void fillBlank() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchInput.sendKeys("сумка женская");
        searchInput.sendKeys(Keys.ENTER);

//        WebElement searchBtn = driver.findElement(By.id("applySearchBtn"));
//        searchBtn.click();
        Thread.sleep(5000);
    }




    @Test
    void checkProfile(){
        WebElement profileBtn = driver.findElement(By.cssSelector("[class='navbar-pc__icon navbar-pc__icon--profile']"));
        profileBtn.click();
        //WebElement userInfo = driver.findElement(By.xpath("//div[contains(@data-link, 'userInfo')]/h2[@class='lk-item__title']"));
       // Assert.assertTrue(userInfo.getText().contains("Айнура"));

    }

    public WebElement scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
